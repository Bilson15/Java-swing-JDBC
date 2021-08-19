/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author gabri
 * @param <T>
 */
public interface DaoGeneric<T> {
    public int gravar(T cliente);
    public int excluir(T cliente);
    public int alterar(T cliente);
    public List<T> buscarTodos();
    public List<T> buscarPorUm(String nome);
    public List<T> buscarPorUm(int nome);
}
