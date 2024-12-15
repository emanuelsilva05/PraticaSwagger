package com.Vieira.Marketplace_extensao3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("API do Trabalho do Reinaldo- Utilizando para PROWEB2").version("1.0.0").description("Estou usando essa API pronta para aprender e demonstrar que sei usar o swagger").license(new License().name("Licença do sistema").url("https://github.com/emanuelsilva05")));
    }

}
