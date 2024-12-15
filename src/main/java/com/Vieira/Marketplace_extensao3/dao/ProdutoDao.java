/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.dao;

import com.Vieira.Marketplace_extensao3.config.Conexao;
import com.Vieira.Marketplace_extensao3.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emanuel
 */
public class ProdutoDao {
    private Conexao conexao;
    private PreparedStatement ps;
    
    public ProdutoDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT * FROM Produto");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Produto produto){
        try {
            System.out.println(produto.getIdVendedor());
            System.out.println(produto.getNome());
            String SQL = "INSERT INTO Produto(id_produto, nome ,descricao, preco, estoque, id_vendedor) " +
                    "VALUES (? ,?, ?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, produto.getId());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());           
            ps.setDouble(4, produto.getPreco());           
            ps.setInt(5, produto.getEstoque()); 
            ps.setInt(6, produto.getIdVendedor());

            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Produto produto){
        try {

            String SQL = "DELETE FROM Produto WHERE id_produto = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, produto.getId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Produto produto){
        try {
            String SQL = "UPDATE Produto SET " +
                        "nome= ?, descricao= ? , preco= ?" +
                        "WHERE id_produto=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao()); 
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getId());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
     public int buscarCpf(String cpf) throws SQLException{

        
        try {
             // Consulta SQL para buscar o ID pela coluna CPF
            String SQL = "SELECT id_vendedor FROM Vendedor WHERE cpf = ?"; // Substitua 'sua_tabela' pelo nome da sua tabela
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            // Substitui o valor do CPF na consulta
            ps.setString(1, cpf);

            // Executa a consulta
            ResultSet rs = ps.executeQuery();

            // Verifica se encontrou o registro
            if (rs.next()) {
                return rs.getInt("id_vendedor"); // Pega o ID da tabela
                
            } else {
                System.out.println("CPF não encontrado.");
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
      }
     
      // Método para buscar um produto pelo nome
    public Produto buscarProdutoPorNome(String nomeProduto) throws SQLException {
        String sql = "SELECT * FROM produto WHERE nome = ?";
        Produto produto = null;

        try (PreparedStatement stmt = conexao.getConn().prepareStatement(sql)) {
            stmt.setString(1, nomeProduto); // Define o nome como parâmetro para a consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto(
                    rs.getInt("id_produto"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                        rs.getInt("id_vendedor")
                );
            }
        }
        return produto;
    }
}
