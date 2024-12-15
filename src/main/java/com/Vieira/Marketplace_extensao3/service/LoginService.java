/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Vieira.Marketplace_extensao3.service;

import com.Vieira.Marketplace_extensao3.dao.LoginDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emanuel
 */
@Service
public class LoginService {
    private LoginDao daoLogin;
    
    public LoginService() {
       daoLogin= new LoginDao();
    }

    public boolean validarLogin(String cpf, String senha, String tipoUsuario) {
        return daoLogin.validarLogin(cpf, senha, tipoUsuario);
    }
}
