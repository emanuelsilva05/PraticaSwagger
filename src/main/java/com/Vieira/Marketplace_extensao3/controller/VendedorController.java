
package com.Vieira.Marketplace_extensao3.controller;

import com.Vieira.Marketplace_extensao3.model.Vendedor;
import com.Vieira.Marketplace_extensao3.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @Operation(summary = "Listar", description = "Método que retorna todos vendedores", tags = "Vendedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou os vendedores"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @GetMapping
    public List<Vendedor> listarVendedores() {
        return vendedorService.listarTodos(); // Chama o novo método no service
    }


    @Operation(summary = "Criar", description = "Método que cria um vendedor", tags = "Vendedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionou o vendedor"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PostMapping
    public String inserirVendedor(@RequestBody Vendedor vendedor) {
        boolean sucesso = vendedorService.inserir(vendedor);
        return sucesso ? "Vendedor inserido com sucesso!" : "Erro ao inserir vendedor, verifique os dados.";
    }

    @Operation(summary = "Atualizar", description = "Método que atualiza um vendedor", tags = "Vendedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizou o vendedor"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PutMapping("/{id}")
    public String editarVendedor(@PathVariable("id") int id, @RequestBody Vendedor vendedor) {
        vendedor.setId(id);
        boolean sucesso = vendedorService.editar(vendedor);
        return sucesso ? "Vendedor atualizado com sucesso!" : "Erro ao atualizar vendedor, verifique os dados.";
    }

//    @DeleteMapping("/{id}")
//    public String excluirVendedor(@PathVariable("id") int id, @RequestBody Vendedor vendedor) {
//        vendedor.setId(id);
//        boolean sucesso = vendedorService.excluir(vendedor);
//        return sucesso ? "Vendedor excluído com sucesso!" : "Erro ao excluir vendedor, verifique os dados.";
//    }
}
