/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.service;

import com.Vieira.Marketplace_extensao3.model.Pedido;
import com.Vieira.Marketplace_extensao3.dao.PedidoDao;
import com.Vieira.Marketplace_extensao3.model.Produto;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PedidoService {

    private PedidoDao daoPedido;

    public PedidoService() {
        daoPedido = new PedidoDao();
    }

    // Método para salvar o pedido
    public void salvarPedido(Pedido pedido) {
        try {
            daoPedido.salvarPedido(pedido); // Chama o método do DAO para salvar o pedido
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o pedido", e);
        }
    }
    
    // Método para gerar o protocolo
    public String gerarProtocolo() {
        // Obtém a data e hora atual
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dataHora = sdf.format(new Date());
        
        // Adiciona um número aleatório (de 1000 a 9999) para aumentar a aleatoriedade
        Random random = new Random();
        int numeroAleatorio = random.nextInt(9000) + 1000;  // Gera um número entre 1000 e 9999
        
        // Combina a data/hora com o número aleatório para gerar o protocolo
        return dataHora + numeroAleatorio;
    }

    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            ResultSet rs = daoPedido.listar(); // Chama o método original que retorna ResultSet
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setProtocolo(rs.getString("protocolo"));
                pedido.setData(rs.getDate("data"));
                pedido.setIdComprador(rs.getInt("id_comprador"));
                pedido.setIdProduto(rs.getInt("id_produto"));
                pedido.setIdFormaPagamento(rs.getInt("id_formaPagamento"));

                pedidos.add(pedido);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendedores", e);
        }
        return pedidos;
    }

//    // Método para buscar um pedido por ID
//    public Pedido buscarPedidoPorId(int idPedido) {
//        try {
//            return DaoPedido.buscarPedidoPorId(idPedido); // Chama o método do DAO para buscar o pedido
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao buscar o pedido", e);
//        }
//    }
//
//    // Método para buscar todos os pedidos de um cliente
//    public List<Pedido> buscarPedidosPorCliente(int idCliente) {
//        try {
//            return DaoPedido.buscarPedidosPorCliente(idCliente); // Chama o método do DAO para buscar os pedidos
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao buscar os pedidos do cliente", e);
//        }
//    }
}
