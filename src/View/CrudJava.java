/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConexaoBanco;
import Dao.DaoItemEstoque;
import Dao.DaoItemPedido;
import Dao.DaoPedido;
import Dao.DaoProduto;
import Dao.DaoVendedor;
import Dao.Relatorios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Estoque;
import model.ItemEstoque;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.Vendedor;
/**
 *
 * @author Usuario
 */
public class CrudJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.err.println(ConexaoBanco.ConexaoBanco());
       Relatorios re = new Relatorios();
        
     /*   
        Cliente cli = new Cliente(70600140121L, "Gabriel", new Date(), "23123");
        Vendedor ven = new Vendedor("sei la", "213212");
        ven.setMatricula(22);
        ped.setVendedor(ven);
        ped.setCliente(cli);
       */
        re.valorTotalVendidoPorProduto();
        
 
        
        
        
    }
    
}
