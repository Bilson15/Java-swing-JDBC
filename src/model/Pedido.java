/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author gabri
 */
public class Pedido {
    
   private int codigo; 
   private Cliente cliente;
   private String data;
   
    public Pedido(int codigo, Cliente cliente, String data) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.data = data;
    }
    
    public Pedido(){
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
 
    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + '}'+ "\n";
    }
    
    
    
   
   
}
