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
import model.Estoque;
import model.ItemEstoque;
import model.Pedido;
import model.Produto;

/**
 *
 * @author gabri
 */
public class DaoItemEstoque{
    private Connection con;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public DaoItemEstoque(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    
    
            
    public List<ItemEstoque> buscarTodos(){
        String sql = "SELECT PRO_ID, PRO_NOME, PRO_PRECO, ITEM_EST_COD, ITEM_EST_QUANTIDADE, EST_ID, EST_NOME "
                + "FROM PRODUTO INNER JOIN ITEM_ESTOQUE ON PRO_ID = ITEM_EST_PRODUTO INNER JOIN ESTOQUE ON EST_ID = ITEM_EST_EST_ID";
        List<ItemEstoque> itemEstoque = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();
                while(result.next()) {
                        ItemEstoque is = new ItemEstoque();
                        Produto pro = new Produto();
                        Estoque est = new Estoque();
                        pro.setCodigo(result.getInt("PRO_ID"));
                        pro.setNome(result.getString("PRO_NOME"));
                        pro.setPreco(result.getDouble("PRO_PRECO")); 
                        is.setCod(result.getInt("ITEM_EST_COD"));
                        is.setQuantidade(result.getInt("ITEM_EST_QUANTIDADE"));
                        est.setId(result.getInt("EST_ID"));
                        est.setNome(result.getString("EST_NOME"));
                        is.setProduto(pro);
                        is.setEstoque(est);
                        itemEstoque.add(is);                      
                }

                return itemEstoque;
        } catch (SQLException e) {
                return null;
        }
    }
    
    
    public List<ItemEstoque> buscarPorNomeProduto(String nome){
        String sql = "SELECT PRO_ID, PRO_NOME, PRO_PRECO, ITEM_EST_COD, ITEM_EST_QUANTIDADE, EST_ID, EST_NOME "
                + "FROM PRODUTO INNER JOIN ITEM_ESTOQUE ON PRO_ID = ITEM_EST_PRODUTO INNER JOIN ESTOQUE ON EST_ID = ITEM_EST_EST_ID WHERE PRO_NOME LIKE '%"+nome+"%'";
        List<ItemEstoque> itemEstoque = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();
                while(result.next()) {
                        ItemEstoque is = new ItemEstoque();
                        Produto pro = new Produto();
                        Estoque est = new Estoque();
                        pro.setCodigo(result.getInt("PRO_ID"));
                        pro.setNome(result.getString("PRO_NOME"));
                        pro.setPreco(result.getDouble("PRO_PRECO")); 
                        is.setCod(result.getInt("ITEM_EST_COD"));
                        is.setQuantidade(result.getInt("ITEM_EST_QUANTIDADE"));
                        est.setId(result.getInt("EST_ID"));
                        est.setNome(result.getString("EST_NOME"));
                        is.setProduto(pro);
                        is.setEstoque(est);
                        itemEstoque.add(is);                      
                }

                return itemEstoque;
        } catch (SQLException e) {
                return null;
        }
    }
    
    
    public int atualizaQuantidadeEstoque(int quantidade, int codigoProduto){
        String sql = "UPDATE ITEM_ESTOQUE SET item_est_quantidade = item_est_quantidade + ? WHERE item_est_produto = ?";

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, quantidade);
            stm.setInt(2, codigoProduto);
            return stm.executeUpdate();

        } catch (SQLException e) {
           return 0;
        }
    }

    
    
}
