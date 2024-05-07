package br.com.gestaosalario.gestaoempresa.infra.security;

import br.com.gestaosalario.gestaoempresa.application.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class ComparingTokenAndUser {
    private final TokenService tokenService;

    public ComparingTokenAndUser(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public String comparing(Long id, HttpServletRequest request){
        tokenService.recoverToken(request);
        return null;
    }
}
