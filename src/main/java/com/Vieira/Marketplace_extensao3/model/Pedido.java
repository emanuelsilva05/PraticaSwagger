/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Date;

public class Pedido {

    private int idPedido;
    private String protocolo;
    private Date data;
    private int idComprador;
    private int idProduto;
    private int idFormaPagamento;

    public Pedido(){

    }

    // Construtor
    public Pedido(String protocolo, Date data, int idComprador, int idProduto, int idFormaPagamento) {
        this.protocolo = protocolo;
        this.data = data;
        this.idComprador = idComprador;
        this.idProduto = idProduto;
        this.idFormaPagamento = idFormaPagamento;
    }

    // Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }
    
    
   
}

