package com.Vieira.Marketplace_extensao3.dao;

import com.Vieira.Marketplace_extensao3.config.Conexao;
import com.Vieira.Marketplace_extensao3.model.Pedido;
import java.sql.*;

public class PedidoDao {

    private Conexao conexao;
    private PreparedStatement ps;

    public PedidoDao() {
         conexao = new Conexao();  
    }

    // Método para salvar o pedido no banco de dados
    public void salvarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (protocolo, data, id_comprador, id_produto, id_formaPagamento) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.getConn().prepareStatement(sql)) {
            stmt.setString(1, pedido.getProtocolo()); // Protocolo gerado
            stmt.setDate(2, new java.sql.Date(pedido.getData().getTime())); // Data da compra
            stmt.setInt(3, pedido.getIdComprador()); // ID do comprador
            stmt.setInt(4, pedido.getIdProduto()); // ID do produto
            stmt.setInt(5, pedido.getIdFormaPagamento()); // ID da forma de pagamento

            stmt.executeUpdate(); // Executa a inserção no banco
        }
    }
        public ResultSet listar(){
            try {
                return conexao.getConn()
                        .createStatement().executeQuery("SELECT * FROM pedido");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return null;
        }


//    // Método para buscar um pedido por ID
//    public Pedido buscarPedidoPorId(int idPedido) throws SQLException {
//        String sql = "SELECT * FROM pedido WHERE nome = ?";
//        Pedido pedido = null;
//
//        try (PreparedStatement stmt = conexao.getConn().prepareStatement(sql)) {
//            stmt.setInt(1, idPedido);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                pedido = new Pedido(
//                    rs.getInt("id_pedido"),
//                    rs.getString("protocolo"),
//                    rs.getDate("data"),
//                    rs.getInt("id_comprador"),
//                    rs.getInt("id_produto"),
//                    rs.getInt("id_formaPagamento")
//                );
//            }
//        }
//        return pedido;
//    }
//
//    // Método para buscar todos os pedidos de um cliente
//    public List<Pedido> buscarPedidosPorCliente(int idCliente) throws SQLException {
//        String sql = "SELECT * FROM pedido WHERE id_comprador = ?";
//        List<Pedido> pedidos = new ArrayList<>();
//
//        try (PreparedStatement stmt = conexao.getConn().prepareStatement(sql)) {
//            stmt.setInt(1, idCliente);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Pedido pedido = new Pedido(
//                    rs.getInt("id_pedido"),
//                    rs.getString("protocolo"),
//                    rs.getDate("data"),
//                    rs.getInt("id_comprador"),
//                    rs.getInt("id_produto"),
//                    rs.getInt("id_formaPagamento")
//                );
//                pedidos.add(pedido);
//            }
//        }
//        return pedidos;
//    }
}
