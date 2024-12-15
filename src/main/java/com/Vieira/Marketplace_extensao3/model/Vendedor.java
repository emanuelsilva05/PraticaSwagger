/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.model;

/**
 *
 * @author Emanuel
 */
public class Vendedor extends Usuario {
    
    private String cnpj;

    public Vendedor() {
    }
    
    public Vendedor(int id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha);
    }
    
    public Vendedor(int id, String nome, String cpf, String senha, String cnpj) {
        super(id, nome, cpf, senha);
        this.cnpj=cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "cnpj=" + cnpj + '}';
    }
    
    
    
}
