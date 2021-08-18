/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoItemPedido;
import Dao.DaoPedido;
import Dao.DaoProduto;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ItemPedido;
import model.Produto;
/**
 *
 * @author Usuario
 */
public class CrudJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
        Cliente cli = new Cliente(13, "Gabriel", "13132", "123123");
        Produto pro = new Produto(15, "Teclado", 150.00);
        
        ItemPedido ip = new ItemPedido(pro, 15, 1, 10);
        
        DaoItemPedido daoI = new DaoItemPedido();
        
        System.out.println(daoI.gravarEmBanco(ip));
        */
       
       DaoPedido dao = new DaoPedido();
       System.out.println(dao.pesquisarPorNome(706));
        
    }
    
}
