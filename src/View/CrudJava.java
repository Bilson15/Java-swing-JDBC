/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConexaoBanco;
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
        //System.err.println(ConexaoBanco.ConexaoBanco());
        
        String cpf = "70600140121";
        
        System.out.println(Long.parseLong(cpf));
        
    }
    
}
