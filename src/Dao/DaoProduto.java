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
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author Usuario
 */
public class DaoProduto {
   private Connection con;
    
    public DaoProduto(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    public int gravarProduto(Produto produto){
        String sql = "INSERT INTO PRODUTO (PRO_ID, PRO_NOME, PRO_PRECO) "
                + "VALUES(?, ?, ?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setDouble(3, produto.getPreco());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    
    public int excluirProduto(Produto produto){
        String sql = "DELETE FROM PRODUTO WHERE PRO_ID = ?";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    
    public int alterarProduto(Produto produto){
        String sqlP = "UPDATE PRODUTO SET PRO_NOME = ?, PRO_PRECO = ? WHERE PRO_ID = ?";
                  
        try{
            PreparedStatement stm = con.prepareStatement(sqlP);
            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPreco());
            stm.setInt(3, produto.getCodigo());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    public List<Produto> pegarTudo(){
        String sql = "SELECT * FROM PRODUTO";
        List<Produto> produtos = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                        Produto pro = new Produto();
                        pro.setCodigo(result.getInt("PRO_ID"));
                        pro.setNome(result.getString("PRO_NOME"));
                        pro.setPreco(result.getDouble("PRO_PRECO"));
                        produtos.add(pro);
                }

                return produtos;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
    
    public Produto pesquisarPorNome(String produtoNome){
        String sql = "SELECT * FROM PRODUTO WHERE PRO_NOME LIKE '%"+produtoNome+"%'";
        Produto pro = new Produto();
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()) {
                pro.setCodigo(result.getInt("PRO_ID"));
                pro.setNome(result.getString("PRO_NOME"));
                pro.setPreco(result.getDouble("PRO_PRECO"));
            }

            return pro;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
    
    
}
