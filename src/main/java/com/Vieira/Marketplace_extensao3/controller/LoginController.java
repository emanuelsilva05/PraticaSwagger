
package com.Vieira.Marketplace_extensao3.controller;

import com.Vieira.Marketplace_extensao3.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "Validar", description = "Método que valida o usuário", tags = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login validado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")

    })
    @PostMapping
    public String validarLogin(@RequestParam String cpf, @RequestParam String senha, @RequestParam String tipoUsuario) {
        boolean valido = loginService.validarLogin(cpf, senha, tipoUsuario);
        return valido ? "Login válido!" : "Credenciais inválidas!";
    }
}
