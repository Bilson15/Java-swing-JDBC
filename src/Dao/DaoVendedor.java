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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Vendedor;

/**
 *
 * @author gabri
 */
public class DaoVendedor implements DaoGeneric<Vendedor> {

    private final Connection con;
    
    public DaoVendedor(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    @Override
    public int gravar(Vendedor vendedor) {
        String sql = "INSERT INTO VENDEDOR (VEN_NOME, VEN_CONTATO) "
                + "VALUES(?, ?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, vendedor.getNome());
            stm.setString(2, vendedor.getContato());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }

    @Override
    public int excluir(Vendedor vendedor) {
        String sql = "DELETE FROM VENDEDOR WHERE VEN_MAT = ?";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, vendedor.getMatricula());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }

    @Override
    public int alterar(Vendedor vendedor) {
    String sql = "UPDATE VENDEDOR SET VEN_NOME = ?, VEN_CONTATO = ? WHERE VEN_MAT = ?";
                  
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, vendedor.getNome());
            stm.setString(2, vendedor.getContato());
            stm.setInt(3, vendedor.getMatricula());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }

    @Override
    public List<Vendedor> buscarTodos() {
                String sql = "SELECT * FROM VENDEDOR";
        List<Vendedor> vendedores = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

            while(result.next()) {
                    Vendedor ven = new Vendedor();
                    ven.setMatricula(result.getInt("VEN_MAT"));
                    ven.setNome(result.getString("VEN_NOME"));
                    ven.setContato(result.getString("VEN_CONTATO"));
                    vendedores.add(ven);
            }

            return vendedores;
        } catch (SQLException e) {
                return null;
        }
    }

    @Override
    public List<Vendedor> buscarPorUm(String nome) {
        String sql = "SELECT * FROM VENDEDOR WHERE VEN_NOME LIKE '%"+nome+"%'";
        List<Vendedor> vendedores = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()) {
                Vendedor ven = new Vendedor();
                ven.setMatricula(result.getInt("VEN_MAT"));
                ven.setNome(result.getString("VEN_NOME"));
                ven.setContato(result.getString("VEN_CONTATO"));
                vendedores.add(ven);
            }

            return vendedores;
        } catch (SQLException e) {
                return null;
        }
    }

    @Override
    public List<Vendedor> buscarPorUm(int mat) {

        return null;
        
    }
    
    
    
    public Vendedor buscarPorUmMat(int mat) {
        String sql = "SELECT * FROM VENDEDOR WHERE VEN_MAT = ?";
        Vendedor ven = new Vendedor();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, mat);
            ResultSet result = stm.executeQuery();

            while(result.next()) {
                ven.setMatricula(result.getInt("VEN_MAT"));
                ven.setNome(result.getString("VEN_NOME"));
                ven.setContato(result.getString("VEN_CONTATO"));
            }

            return ven;
        } catch (SQLException e) {
                return null;
        }
    }
    
    
}
