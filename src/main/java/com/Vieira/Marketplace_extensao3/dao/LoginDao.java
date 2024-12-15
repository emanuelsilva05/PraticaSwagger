/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.dao;

import com.Vieira.Marketplace_extensao3.config.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Emanuel
 */
public class LoginDao {
 

/**
 *
 * @author Emanuel
 */
     private Conexao conexao;

    public LoginDao() {
       conexao = new Conexao();
    }

    public boolean validarLogin(String cpf, String senha, String tipoUsuario) {
        // Definir a consulta SQL dependendo do tipo de usuário (comprador ou vendedor)
        String query = "";
        
        if (tipoUsuario.equals("Comprador")) {
            query = "SELECT cpf, senha FROM comprador WHERE cpf = ? AND senha = ?";
        } else if (tipoUsuario.equals("Vendedor")) {
            query = "SELECT cpf, senha FROM vendedor WHERE cpf = ? AND senha = ?";
        }
        
        System.out.println(query);
        try (PreparedStatement ps =  conexao.getConn().prepareStatement(query)) {
            // Substitui os "?" pelos parâmetros
            ps.setString(1, cpf);
            ps.setString(2, senha);

            // Executa a consulta
            ResultSet rs = ps.executeQuery();

            System.out.println(rs);
            // Verifica se um resultado foi encontrado
            return rs.next(); // Se encontrar, retorna true (login válido)
            // Se não encontrar, retorna false (login inválido)
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Retorna false em caso de erro na consulta
        }
    }
}

