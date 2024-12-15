/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.service;

import com.Vieira.Marketplace_extensao3.model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Vieira.Marketplace_extensao3.dao.ProdutoDao;
import com.Vieira.Marketplace_extensao3.model.Vendedor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emanuel
 */
@Service
public class ProdutoService {
    private ProdutoDao daoProduto;
    
    public ProdutoService(){
        daoProduto = new ProdutoDao();
    }
    
    public ResultSet listar(){
        return daoProduto.listar();
    }
    
    public boolean inserir(Produto produto){
        
        if (produto.getNome().isEmpty()){
            return false;
        } else {
            daoProduto.inserir(produto);
            return true;
        }
    }
    
//    public boolean excluir(Produto produto){
//        if (produto.getId() == 0)
//            return false;
//
//        daoProduto.excluir(produto);
//        return true;
//    }
    
    public boolean editar(Produto produto){
        if (produto.getNome().isEmpty())
            return false;
        
        daoProduto.editar(produto);
        return true;
    }
    
    public int buscarCpf(String cpf) throws SQLException{
        return daoProduto.buscarCpf(cpf);
    }

    public Produto buscarProdutoPorNome(String nomeProduto) throws SQLException {
        return daoProduto.buscarProdutoPorNome(nomeProduto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            ResultSet rs = daoProduto.listar(); // Chama o método original que retorna ResultSet
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setIdVendedor(rs.getInt("id_vendedor"));

                produtos.add(produto);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendedores", e);
        }
        return produtos;
    }
}
