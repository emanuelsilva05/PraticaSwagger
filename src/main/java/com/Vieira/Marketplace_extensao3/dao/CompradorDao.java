/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.dao;

import com.Vieira.Marketplace_extensao3.config.Conexao;
import com.Vieira.Marketplace_extensao3.model.Comprador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emanuel
 */
public class CompradorDao {
    private Conexao conexao;
    private PreparedStatement ps;
    
    public CompradorDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT * FROM Comprador");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Comprador comprador){
        try {
            String SQL = "INSERT INTO Comprador(id_comprador, nome, cpf, endereco, senha) " +
                    "VALUES (? ,?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, comprador.getId());
            ps.setString(2, comprador.getNome());
            ps.setString(3, comprador.getCpf());           
            ps.setString(4, comprador.getEndereco());           
            ps.setString(5, comprador.getSenha()); 
            
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean excluir(Comprador comprador){
        try {
            String SQL = "DELETE FROM Comprador WHERE id_comprador = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, comprador.getId());

            int rowsAffected = ps.executeUpdate();
                        
            ps.close();

            // executeUpdate retorna o número de linhas afetadas

            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
    public void editar(Comprador comprador){
        try {
            String SQL = "UPDATE Comprador SET " +
                        "nome= ?, cpf= ? , endereco= ?" +
                        "WHERE id_comprador=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, comprador.getNome());
            ps.setString(2, comprador.getCpf()); 
            ps.setString(3, comprador.getEndereco());
            ps.setInt(4, comprador.getId());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Método para buscar cliente pelo CPF
    public Comprador buscarClientePorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM comprador WHERE cpf = ?";
        Comprador comprador = null;

        try (PreparedStatement stmt = conexao.getConn().prepareStatement(sql)) {
            stmt.setString(1, cpf); // Define o CPF como parâmetro para a consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                comprador = new Comprador(
                    rs.getInt("id_Comprador"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getString("endereco")
                );
            }
        }
        return comprador;
    }
}
