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
public class ItemEstoque {
    private int cod;
    private int quantidade;
    private Produto produto;
    private Estoque estoque;

    public ItemEstoque(int cod, int quantidade, Produto produto, Estoque estoque) {
        this.cod = cod;
        this.quantidade = quantidade;
        this.produto = produto;
        this.estoque = estoque;
    }
    
    public ItemEstoque(){
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "ItemEstoque{" + "cod=" + cod + ", quantidade=" + quantidade + ", produto=" + produto + ", estoque=" + estoque + '}';
    }
    
    
    
    
}
