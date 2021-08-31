/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author gabri
 */
public class Relatorios {
    private final Connection con;

    
    public Relatorios(){
        this.con = ConexaoBanco.ConexaoBanco();
    }
    
    public String quantidadePedidosCliente(){
        String resultado = "--NOME--|--QUANTIDADE--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := NOME_CLIENTE_PEDIDOS; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getString("CLI_NOME") + " | " + rs.getInt("COUNT(PED_NUM)") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }   
    
    
    public String produtoMaisVendido(){
        String resultado = "--NOME--|--PREÇO--|--TOTAL VENDIDO--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := PRODUTO_MAIS_VENDIDO; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getString("PRO_NOME") + "  |  " + rs.getDouble("PRO_PRECO")
                           + "  |  " + rs.getInt("TOTAL") + "\n";
            }
            
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    } 
    
    
    public String produtoMenosVendido(){
         String resultado = "--NOME--|--PREÇO--|--TOTAL VENDIDO--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := PRODUTO_MENOS_VENDIDO; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getString("PRO_NOME") + "  |  " + rs.getDouble("PRO_PRECO")
                           + "  |  " + rs.getInt("TOTAL") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }
    
    public String totalPedido(){
        String resultado = "--CLIENTE--|--PEDIDO--|--TOTAL--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := TOTAL_PEDIDO; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getString("CLI_NOME")+ "  |  " + rs.getInt("PED_NUM")
                         + "  |  " + rs.getDouble("TOTAL_PEDIDO") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }
    
    public String pedidoValorMaiorMedia(){
        String resultado = "--CLIENTE--|--PEDIDO--|--TOTAL--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := PEDIDO_VALOR_MAIOR_MEDIA; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getString("CLI_NOME")+ "  |  "+rs.getInt("PED_NUM")
                        + "  |  " + rs.getDouble("TOTAL_PEDIDO") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }
    
    
    public String produtoComEstoqueMenor10(){
        String resultado = "--ID--|--NOME--|--QUANTIDADE--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := PRODUTO_ESTOQUE_MENOR_10; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getInt("PRO_ID")+ "  |  "+rs.getString("PRO_NOME")
                        + "  |  "+ rs.getInt("ITEM_EST_QUANTIDADE") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }
    
    
    public String valorTotalVendidoPorProduto(){
        String resultado = "--ID--|--NOME--|--SOMA--\n";
        
        try {
            CallableStatement cs = con.prepareCall ("begin ? := VALOR_TOTAL_VENDIDO_PRODUTO; end;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                resultado += rs.getInt("PRO_ID") + "  |  "+rs.getString("PRO_NOME")
                        + "  |  "+ rs.getDouble("SOMA") + "\n";
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return resultado;
        }


    }
    
    
    
    
    
    
    
    
}
