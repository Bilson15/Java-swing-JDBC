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
public class Vendedor {
    private int matricula;
    private String nome;
    private String contato;

    public Vendedor(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }
    
    public Vendedor(){
        
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "matricula=" + matricula + ", nome=" + nome + ", contato=" + contato + '}';
    }
    
    
    
    
    
    
}
