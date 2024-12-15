
package com.Vieira.Marketplace_extensao3.controller;

import com.Vieira.Marketplace_extensao3.model.Comprador;
import com.Vieira.Marketplace_extensao3.service.CompradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe responsável por determinar as ações dos métodos http dos compradores.
 */
@RestController
@RequestMapping("/api/compradores")
public class CompradorController {


    /**
     * Intanciando um CompradorService com o autowirend.
     */
    @Autowired
    private CompradorService compradorService;


    /**
     * Método responsavel por listar os compradores através dos método get.
     */
    @Operation(summary = "Listar", description = "Método que retorna todos os compradores", tags = "Compradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou os compradores"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @GetMapping
    public List<Comprador> listarCompradores() {
        return compradorService.listarTodos();
    }



    /**
     * Não está em uso.
     */
//    @GetMapping("/{cpf}")
//    public Comprador buscarClientePorCpf(@PathVariable String cpf) throws SQLException {
//        return compradorService.buscarClientePorCpf(cpf);
//    }


    /**
     * Método responsavel por listar os compradores através dos método post.
     */
    @Operation(summary = "Criar", description = "Método que cria um comprador", tags = "Compradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionou o comprador"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PostMapping
    public String inserirComprador(@RequestBody Comprador comprador) {
        boolean sucesso = compradorService.inserir(comprador);
        return sucesso ? "Comprador inserido com sucesso!" : "Erro ao inserir comprador, verifique os dados.";
    }



    @Operation(summary = "Atualizar", description = "Método que atualiza um comprador", tags = "Compradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizou o comprador"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PutMapping("/{id}")
    public String editarComprador(@PathVariable("id") int id, @RequestBody Comprador comprador) {
        comprador.setId(id);
        boolean sucesso = compradorService.editar(comprador);
        return sucesso ? "Comprador atualizado com sucesso!" : "Erro ao atualizar comprador, verifique os dados.";
    }

    /**
     * Não está em uso.
     */
//    @DeleteMapping("/{id}")
//    public String excluirComprador(@PathVariable("id") int id, @RequestBody Comprador comprador) {
//        comprador.setId(id);
//        boolean sucesso = compradorService.excluir(comprador);
//        return sucesso ? "Comprador excluído com sucesso!" : "Erro ao excluir comprador, verifique os dados.";
//    }
}
