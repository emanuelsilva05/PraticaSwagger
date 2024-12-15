
package com.Vieira.Marketplace_extensao3.controller;

import com.Vieira.Marketplace_extensao3.model.Pedido;
import com.Vieira.Marketplace_extensao3.model.Vendedor;
import com.Vieira.Marketplace_extensao3.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @Operation(summary = "Criar", description = "Método que cria um pedido", tags = "Pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionou o pedido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PostMapping
    public String salvarPedido(@RequestBody Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        return "Pedido salvo com sucesso!";
    }


    @Operation(summary = "Listar", description = "Método que retorna todos os pedidos", tags = "Pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou os pedidos"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodos(); // Chama o novo método no service
    }
}
