/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import java.sql.*;
import model.Produto;

/**
 *
 * @author Usuario
 */
public class DaoCliente implements DaoGeneric<Cliente> {
    private final Connection con;
    
    public DaoCliente(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    @Override
    public int gravar(Cliente  cliente){
        String sql = "INSERT INTO CLIENTES (CLI_CPF, CLI_NOME, CLI_DATA_NASCIMENTO, CLI_CONTATO) "
                + "VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getDataNascimento());
            stm.setString(4, cliente.getContato());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }

    @Override
    public int excluir(Cliente cliente){
        String sql = "DELETE FROM CLIENTES WHERE CLI_CPF = ?";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, cliente.getCpf());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }

    @Override
    public int alterar(Cliente cliente){
    String sql = "UPDATE CLIENTES SET CLI_NOME = ?, CLI_DATA_NASCIMENTO = ?, CLI_CONTATO = ? WHERE CLI_CPF = ?";
                  
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getDataNascimento());
            stm.setString(3, cliente.getContato());
            stm.setLong(4, cliente.getCpf());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    @Override
    public List<Cliente> buscarTodos(){
        String sql = "SELECT * FROM CLIENTES";
        List<Cliente> clientes = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                        Cliente cli = new Cliente();
                        cli.setCpf(result.getLong("CLI_CPF"));
                        cli.setNome(result.getString("CLI_NOME"));
                        cli.setDataNascimento(result.getString("CLI_DATA_NASCIMENTO"));
                        cli.setContato(result.getString("CLI_CONTATO"));
                        clientes.add(cli);
                }

                return clientes;
        } catch (SQLException e) {
                return null;
        }
    }
    @Override
    public List<Cliente> buscarPorUm(String clienteNome){
        String sql = "SELECT * FROM CLIENTES WHERE CLI_NOME LIKE '%"+clienteNome+"%'";
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()) {
                Cliente cli = new Cliente();
                cli.setCpf(result.getLong("CLI_CPF"));
                cli.setNome(result.getString("CLI_NOME"));
                cli.setDataNascimento(result.getString("CLI_DATA_NASCIMENTO"));
                cli.setContato(result.getString("CLI_CONTATO"));
                clientes.add(cli);
            }

            return clientes;
        } catch (SQLException e) {
                return null;
        }
    }
    
    @Override
    public List<Cliente> buscarPorUm(int id){
        return null;
    }
    
}
