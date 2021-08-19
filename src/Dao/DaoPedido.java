/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import java.sql.Statement;


/**
 *
 * @author Usuario
 */
public class DaoPedido implements DaoGeneric<Pedido>{
   private Connection con;
    
    public DaoPedido(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
   @Override
    public int gravar(Pedido pedido){
        String sql = "INSERT INTO PEDIDO (PED_NUM, PED_DATA, PED_CLI_CPF) "
                + "VALUES(?,?,?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, pedido.getCodigo());
            stm.setString(2, pedido.getData());
            stm.setInt(3, pedido.getCliente().getCpf());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    
   @Override
    public int excluir(Pedido pedido){
        String sql = "DELETE FROM PEDIDO WHERE PED_NUM = ?";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, pedido.getCodigo());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
 
   @Override
    public List<Pedido> buscarTodos(){
        String sql = "SELECT PED_NUM, PED_DATA, CLIENTES.* " +
                     "FROM CLIENTES INNER JOIN PEDIDO ON CLI_CPF = PED_CLI_CPF";
        
        
        List<Pedido> pedidos = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                        Pedido ped = new Pedido();
                        Cliente cli = new Cliente();
                        ped.setCodigo(result.getInt("PED_NUM"));
                        ped.setData(result.getString("PED_DATA"));
                        cli.setCpf(result.getInt("CLI_CPF"));
                        cli.setNome(result.getString("CLI_NOME"));
                        cli.setDataNascimento(result.getString("CLI_DATA_NASCIMENTO"));
                        cli.setContato(result.getString("CLI_CONTATO"));
                        ped.setCliente(cli);
                        pedidos.add(ped);
                }
                return pedidos;
        } catch (SQLException e) {
                return null;
        }
    }
   @Override
    public List<Pedido> buscarPorUm(int cliCPF){
        String sql = "SELECT PED_NUM, PED_DATA, CLIENTES.* " +
                     "FROM CLIENTES INNER JOIN PEDIDO ON CLI_CPF = PED_CLI_CPF WHERE PED_CLI_CPF LIKE '%"+cliCPF+"%'";
        List<Pedido> pedidos = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()) {
                    Cliente cli = new Cliente();
                    Pedido ped = new Pedido();
                    ped.setCodigo(result.getInt("PED_NUM"));
                    ped.setData(result.getString("PED_DATA"));
                    cli.setCpf(result.getInt("CLI_CPF"));
                    cli.setNome(result.getString("CLI_NOME"));
                    cli.setDataNascimento(result.getString("CLI_DATA_NASCIMENTO"));
                    cli.setContato(result.getString("CLI_CONTATO"));
                    ped.setCliente(cli);
                    pedidos.add(ped);
            }
            return pedidos;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
    
    @Override
    public List<Pedido> buscarPorUm(String nome){
        return null;
    }
    
    @Override
    public int alterar(Pedido pedido){
        return 0;
    }
    
}
