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
public interface Servicos {
    public abstract void calcularSubtotal(ItemPedido itemPedido);
    
    public abstract double calcularTotal(List<ItemPedido> itemPedido);

}
