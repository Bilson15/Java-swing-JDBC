/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.ItemPedido;
import model.Pedido;

/**
 *
 * @author gabri
 */
public class ServicosCrud implements Servicos{

    @Override
    public void calcularSubtotal(ItemPedido itemPedido) {
        double valor = itemPedido.getProduto().getPreco(); 
        valor -= itemPedido.getPorcentagemDesconto() * itemPedido.getProduto().getPreco() / 100;
        itemPedido.getProduto().setPrecoDesconto(valor * itemPedido.getQuantidade());
    }

    @Override
    public double calcularTotal(List<ItemPedido> itemPedido) {
        double valor = 0;
        for (int i = 0; i < itemPedido.size(); i++){
            calcularSubtotal(itemPedido.get(i));
            valor += itemPedido.get(i).getProduto().getPrecoDesconto();
        }
        return valor;
    }
    
}
