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
public class Produto {
    
    private int codigo;
    private String nome;
    private double preco;
    private double precoDesconto;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = 0;
    }
    
    public Produto(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }
    

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + '}';
    }
    
    
    
    
    
    
}
