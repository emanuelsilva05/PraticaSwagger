/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.service;

import com.Vieira.Marketplace_extensao3.model.Comprador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Vieira.Marketplace_extensao3.dao.CompradorDao;
import com.Vieira.Marketplace_extensao3.model.Vendedor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emanuel
 */
@Service
public class CompradorService {

    
   
     private CompradorDao daoComprador;
    
    public CompradorService(){
        daoComprador = new CompradorDao();
    }
    
    public Comprador buscarClientePorCpf(String cpfComprador) throws SQLException {
        return daoComprador.buscarClientePorCpf(cpfComprador);
    }
    
    public ResultSet listar(){
        return daoComprador.listar();
    }
    
    public boolean inserir(Comprador comprador){
        
        if (comprador.getNome().isEmpty() || comprador.getCpf().isEmpty() || comprador.getSenha().isEmpty()){
            return false;
        } else {
            daoComprador.inserir(comprador);
            return true;
        }
    }
    
//    public boolean excluir(Comprador comprador){
//        if (comprador.getId() == 0)
//            return false;
//        return daoComprador.excluir(comprador);
//    }
    
    public boolean editar(Comprador comprador){
        if (comprador.getNome().isEmpty() || comprador.getCpf().isEmpty() || comprador.getSenha().isEmpty())
            return false;
        
        daoComprador.editar(comprador);
        return true;
    }

    public List<Comprador> listarTodos() {
        List<Comprador> compradores = new ArrayList<>();
        try {
            ResultSet rs = daoComprador.listar(); // Chama o método original que retorna ResultSet
            while (rs.next()) {
                Comprador comprador = new Comprador();
                comprador.setId(rs.getInt("id_comprador"));
                comprador.setNome(rs.getString("nome"));
                comprador.setCpf(rs.getString("cpf"));
                comprador.setEndereco(rs.getString("endereco"));
                comprador.setSenha(rs.getString("senha"));

                compradores.add(comprador);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendedores", e);
        }
        return compradores;
    }
}
