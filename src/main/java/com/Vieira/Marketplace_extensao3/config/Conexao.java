package com.Vieira.Marketplace_extensao3.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private Connection conn;
        
    public Conexao() {        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/LojaDeBicicleta", "root", "12345678");

            System.out.println("Conexão criada com sucesso!");
        }
        catch ( ClassNotFoundException | SQLException e ){
            System.out.println("Falha na conexão");
            e.printStackTrace();
        }
    }
    
    public Connection getConn(){
        return conn;
    }
    
    public static void main(String[] args) {
        Conexao c = new Conexao();
    }
}
