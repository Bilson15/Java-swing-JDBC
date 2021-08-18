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
import model.ItemPedido;
import model.Produto;

/**
 *
 * @author Usuario
 */
public class DaoItemPedido {
        private Connection con;
    
    public DaoItemPedido(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    public int gravarEmBanco(ItemPedido itemPedido){
        String sql = "INSERT INTO ITEM_PEDIDO VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, itemPedido.getQuantidade());
            stm.setDouble(2, itemPedido.getPorcentagemDesconto());
            stm.setInt(3, itemPedido.getProduto().getCodigo());
            stm.setInt(4, itemPedido.getPedidoID());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    
    public List<ItemPedido> pegarTudo(){
        String sql = "SELECT ITEM_PED_QUANTIDADE, ITEM_PED_PED_NUM, PRODUTO.*, ITEM_PED_PORC_DESCO "
                + "FROM PEDIDO INNER JOIN ITEM_PEDIDO ON PED_NUM = ITEM_PED_PED_NUM "
                + "INNER JOIN PRODUTO ON PRO_ID = ITEM_PED_PROD_COD ORDER BY ITEM_PED_PED_NUM";
        List<ItemPedido> itemPedidos = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                    ItemPedido itemPedido = new ItemPedido();
                    Produto pro = new Produto();
                    itemPedido.setQuantidade(result.getInt("ITEM_PED_QUANTIDADE"));
                    itemPedido.setPedidoID(result.getInt("ITEM_PED_PED_NUM"));
                    pro.setCodigo(result.getInt("PRO_ID"));
                    pro.setNome(result.getString("PRO_NOME"));
                    pro.setPreco(result.getDouble("PRO_PRECO"));
                    itemPedido.setPorcentagemDesconto(result.getDouble("ITEM_PED_PORC_DESCO"));
                    itemPedido.setProduto(pro);
                    itemPedidos.add(itemPedido);
                }
                return itemPedidos;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
    
    public List<ItemPedido> produtosPedido(int cod){
        String sql = "SELECT item_pedido.item_ped_quantidade, PRODUTO.*, ITEM_PED_PORC_DESCO "
                + "FROM PEDIDO INNER JOIN ITEM_PEDIDO ON PED_NUM = ITEM_PED_PED_NUM "
                + "INNER JOIN PRODUTO ON PRO_ID = ITEM_PED_PROD_COD "
                + "WHERE ITEM_PED_PED_NUM = ?";
        List<ItemPedido> itemPedidos = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1,cod);
                ResultSet result = stm.executeQuery();
                
                while(result.next()) {
                    
                    ItemPedido itemPedido = new ItemPedido();
                    Produto pro = new Produto();
                    itemPedido.setQuantidade(result.getInt("ITEM_PED_QUANTIDADE"));
                    pro.setCodigo(result.getInt("PRO_ID"));
                    pro.setNome(result.getString("PRO_NOME"));
                    pro.setPreco(result.getDouble("PRO_PRECO"));
                    itemPedido.setPorcentagemDesconto(result.getDouble("ITEM_PED_PORC_DESCO"));
                    itemPedido.setProduto(pro);
                    itemPedidos.add(itemPedido);
                }
                return itemPedidos;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
    
    public int excluirItemPedido(ItemPedido itemPedido){
        String sql = "DELETE FROM ITEM_PEDIDO WHERE ITEM_PED_PED_NUM = ?";
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, itemPedido.getPedidoID());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    
    /*
    public int alterarCliente(ItemPedido itemPedido){
    String sql = "UPDATE CLIENTES SET CLI_NOME = ?, CLI_DATA_NASCIMENTO = ?, CLI_CONTATO = ? WHERE CLI_CPF = ?";
                  
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getDataNascimento());
            stm.setString(3, cliente.getContato());
            stm.setInt(4, cliente.getCpf());
            return stm.executeUpdate();
        } catch(SQLException e){
            e.getStackTrace();
            return 0;
        }
    }
    public List<Cliente> pegarTudo(){
        String sql = "SELECT * FROM CLIENTES";
        List<Cliente> clientes = new ArrayList<>();

        try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet result = stm.executeQuery();

                while(result.next()) {
                        Cliente cli = new Cliente();
                        cli.setCpf(result.getInt("CLI_CPF"));
                        cli.setNome(result.getString("CLI_NOME"));
                        cli.setDataNascimento(result.getString("CLI_DATA_NASCIMENTO"));
                        cli.setContato(result.getString("CLI_CONTATO"));
                        clientes.add(cli);
                }

                return clientes;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }
*/
}
