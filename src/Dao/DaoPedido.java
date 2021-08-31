/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import model.Vendedor;


/**
 *
 * @author Usuario
 */
public class DaoPedido implements DaoGeneric<Pedido>{
    private Connection con;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public DaoPedido(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
   @Override
    public int gravar(Pedido pedido){
        String sql = "INSERT INTO PEDIDO (PED_CLI_CPF) "
                + "VALUES(?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, pedido.getCliente().getCpf());
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
                        ped.setData(result.getDate("PED_DATA"));
                        cli.setCpf(result.getLong("CLI_CPF"));
                        cli.setNome(result.getString("CLI_NOME"));
                        cli.setDataNascimento(result.getDate("CLI_DATA_NASCIMENTO"));
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
                    ped.setData(result.getDate("PED_DATA"));
                    cli.setCpf(result.getLong("CLI_CPF"));
                    cli.setNome(result.getString("CLI_NOME"));
                    cli.setDataNascimento(result.getDate("CLI_DATA_NASCIMENTO"));
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
    
    
    
    
    public List<Pedido> buscarTodosVendedorComissao(){
        String sql = "SELECT DISTINCT PED_NUM, PED_DATA, CLIENTES.*, PED_VEN_MAT, PED_COMISSAO "
                + "FROM CLIENTES INNER JOIN PEDIDO ON CLI_CPF = PED_CLI_CPF "
                + "INNER JOIN VENDEDOR ON PED_VEN_MAT = VEN_MAT OR PED_VEN_MAT IS NULL";
        
        
        List<Pedido> pedidos = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                        Pedido ped = new Pedido();
                        Cliente cli = new Cliente();
                        Vendedor ven = new Vendedor();
                        ped.setCodigo(result.getInt("PED_NUM"));
                        ped.setData(result.getDate("PED_DATA"));
                        cli.setCpf(result.getLong("CLI_CPF"));
                        cli.setNome(result.getString("CLI_NOME"));
                        cli.setDataNascimento(result.getDate("CLI_DATA_NASCIMENTO"));
                        cli.setContato(result.getString("CLI_CONTATO"));
                        ven.setMatricula(result.getInt("PED_VEN_MAT"));
                        ped.setVendedor(ven);
                        
                        if(ped.getVendedor().getMatricula() == 0){
                            Vendedor venn = new Vendedor("Sem Vendedor", "--");
                            ped.setVendedor(venn);
                        }else{
                            DaoVendedor dao = new DaoVendedor();
                            Vendedor vendedor = dao.buscarPorUmMat(ped.getVendedor().getMatricula());
                            ped.getVendedor().setNome(vendedor.getNome());
                            ped.getVendedor().setContato(vendedor.getContato());
                        }

                        ped.setComissao(result.getDouble("PED_COMISSAO"));
                                              
                        ped.setCliente(cli);
                        pedidos.add(ped);
                }
                return pedidos;
        } catch (SQLException e) {
                return null;
        }
        
    }

    public int gravarComVendedor(Pedido pedido){
        String sql = "INSERT INTO PEDIDO (PED_CLI_CPF, PED_VEN_MAT) "
                + "VALUES(?, ?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, pedido.getCliente().getCpf());
            stm.setInt(2, pedido.getVendedor().getMatricula());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
}
 
