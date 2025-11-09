package com.clasesWithAngela.clasesConAngela.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desactiva CSRF (para facilitar pruebas con Postman o navegador)
                .csrf(csrf -> csrf.disable())
                // Configura que todas las rutas sean públicas
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // Desactiva el login por formulario
                .formLogin(form -> form.disable())
                // Desactiva autenticación HTTP básica
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}
