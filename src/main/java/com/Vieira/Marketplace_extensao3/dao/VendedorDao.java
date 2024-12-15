package com.Vieira.Marketplace_extensao3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Vieira.Marketplace_extensao3.model.Vendedor;
import com.Vieira.Marketplace_extensao3.config.Conexao;

public class VendedorDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public VendedorDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT * FROM Vendedor");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Vendedor vendedor){
        try {
            String SQL = "INSERT INTO vendedor(id_vendedor, nome, cpf, cnpj, senha) " +
                    "VALUES (? ,?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, vendedor.getId());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getCpf());           
            ps.setString(4, vendedor.getCnpj());           
            ps.setString(5, vendedor.getSenha()); 
            
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Vendedor vendedor){
        try {
            String SQL = "DELETE FROM vendedor WHERE id_vendedor = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, vendedor.getId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Vendedor vendedor){
        try {
            String SQL = "UPDATE vendedor SET " +
                        "nome= ?, cpf= ? , cnpj= ?" +
                        "WHERE id_vendedor=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getCpf()); 
            ps.setString(3, vendedor.getCnpj());
            ps.setInt(4, vendedor.getId());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
