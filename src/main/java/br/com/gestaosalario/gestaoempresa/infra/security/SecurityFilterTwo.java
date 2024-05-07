package br.com.gestaosalario.gestaoempresa.infra.security;

import br.com.gestaosalario.gestaoempresa.application.service.TokenService;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;

@Component
public class SecurityFilterTwo extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityFilterTwo(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Entrei no filtro 2");
        String requestUri = request.getRequestURI().toString();
        searchID(requestUri);


        var tokenJWT = recoverToken(request);
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    private String searchID(String requestUri) {
        String[] url = requestUri.toString().split("/");
  //falta treinar o básico kkkk quem diria, mas estou sem cabeça






        return  null;


    }


}
