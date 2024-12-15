package com.Vieira.Marketplace_extensao3.controller;

import com.Vieira.Marketplace_extensao3.model.Produto;
import com.Vieira.Marketplace_extensao3.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Listar", description = "Método que retorna todos os produtos", tags = "Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou os compradores"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarTodos(); // Chama o novo método no service
    }


    @Operation(summary = "Criar", description = "Método que cria um produto", tags = "Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionou o produto"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PostMapping
    public String inserirProdutos(@RequestBody Produto produto) {
        boolean sucesso = produtoService.inserir(produto);
        return sucesso ? "Produto inserido com sucesso!" : "Erro ao inserir produto, verifique os dados.";
    }


    @Operation(summary = "Atualizar", description = "Método que atualiza um produto", tags = "Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizou o produto"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PutMapping("/{id}")
    public String editarProdutos(@PathVariable("id") int id, @RequestBody Produto produto) {
        produto.setId(id);
        boolean sucesso = produtoService.editar(produto);
        return sucesso ? "Produto atualizado com sucesso!" : "Erro ao atualizar produto, verifique os dados.";
    }

//    @DeleteMapping("/{id}")
//    public String excluirProdutos(@PathVariable("id") int id, @RequestBody Produto produto) {
//        produto.setId(id);
//        boolean sucesso = produtoService.excluir(produto);
//        return sucesso ? "Produto excluído com sucesso!" : "Erro ao excluir produto, verifique os dados.";
//    }
}
