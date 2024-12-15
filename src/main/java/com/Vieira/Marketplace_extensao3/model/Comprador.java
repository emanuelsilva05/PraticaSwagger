/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.model;

/**
 *
 * @author Emanuel
 */
public class Comprador extends Usuario {

    private String endereco;
    
    public Comprador() {
    }

    public Comprador(int id, String endereco, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Comprador{" + "endereco=" + endereco + '}';
    }
    
    
}
