package com.Vieira.Marketplace_extensao3.service;

import com.Vieira.Marketplace_extensao3.dao.VendedorDao;
import java.sql.ResultSet;
import com.Vieira.Marketplace_extensao3.model.Vendedor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorService {
    
    private VendedorDao daoVendedor;
    
    public VendedorService(){
        daoVendedor = new VendedorDao();
    }
    
    public ResultSet listar(){
        return daoVendedor.listar();
    }
    
    public boolean inserir(Vendedor vendedor){
        
        if (vendedor.getNome().isEmpty() || vendedor.getCpf().isEmpty() || vendedor.getSenha().isEmpty()){
            return false;
        } else {
            daoVendedor.inserir(vendedor);
            return true;
        }
    }
    
//    public boolean excluir(Vendedor vendedor){
//        if (vendedor.getId() == 0)
//            return false;
//
//        daoVendedor.excluir(vendedor);
//        return true;
//    }
    
    public boolean editar(Vendedor vendedor){
        if (vendedor.getNome().isEmpty() || vendedor.getCpf().isEmpty() || vendedor.getCnpj().isEmpty())
            return false;
        
        daoVendedor.editar(vendedor);
        return true;
    }



    public List<Vendedor> listarTodos() {
        List<Vendedor> vendedores = new ArrayList<>();
        try {
            ResultSet rs = daoVendedor.listar(); // Chama o método original que retorna ResultSet
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id_vendedor"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setCnpj(rs.getString("cnpj"));
                vendedor.setSenha(rs.getString("senha"));

                vendedores.add(vendedor);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendedores", e);
        }
        return vendedores;
    }
}

