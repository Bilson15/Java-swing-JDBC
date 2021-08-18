/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author gabri
 */
public class ItemPedido {
    private int pedidoID;
    private double porcentagemDesconto;
    private Produto produto;
    private int quantidade;

    
    public ItemPedido(Produto produto, int quantidade, int pedidoID, double porcentagemDesconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedidoID = pedidoID;
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    public ItemPedido(){
        
    }

    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
}
