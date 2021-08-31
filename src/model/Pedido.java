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
   private Date data;
   private Vendedor vendedor;
   private double comissao;
   
    public Pedido(Cliente cliente) {
        this.codigo = 0;
        this.cliente = cliente;
        this.data = null;
    }
    
    public Pedido(int codigo,Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.data = null;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public Pedido(){
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", data=" + data + ", vendedor=" + vendedor + ", comissao=" + comissao + '}';
    }
    
 

    
    
    
   
   
}
