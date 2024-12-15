/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.model;

/**
 * Classe para o produto que é a bicicleta.
 * @author Emanuel
 */ 
public class Produto{
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private int idVendedor;

    public Produto() {
    }

    
    
    /**
     * Método contrutor.
     * @param id
     * @param nome String - Modelo da bicicleta.
     * @param descricao String - Tamanho do quadro.
     * @param preco double - Preço da bicicleta.
     * @param id_vendedor
     */
    public Produto(int id, String nome, String descricao, double preco, int idVendedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.idVendedor = idVendedor;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    
    
    public String getNome() {

        return nome;
    }

    public String getDescricao() {

        return descricao;
    }

    public double getPreco() {

        return preco;
    }
    
    public int getEstoque(){

        return estoque;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setDescricao(String descricao){

        this.descricao = descricao;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }
    
    public void setEstoque(int estoque){

        this.estoque= estoque;
    }

    public void setIdVendedor(int idVendedor){

        this.idVendedor= idVendedor;
    }
    public int getIdVendedor() {

        return idVendedor;
    }




    @Override
    public String toString() {
        return "Nome: " + nome + ", Descricao: " + descricao + ", Preço: R$" + preco;
    }
}