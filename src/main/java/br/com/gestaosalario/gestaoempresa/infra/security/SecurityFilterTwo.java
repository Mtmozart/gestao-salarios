package br.com.gestaosalario.gestaoempresa.infra.security;

import br.com.gestaosalario.gestaoempresa.application.service.TokenService;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
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
import java.util.List;
import java.util.OptionalInt;

@Component
public class SecurityFilterTwo extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final EmployeeRepository employeeRepository;

    public SecurityFilterTwo(TokenService tokenService, EmployeeRepository employeeRepository) {
        this.tokenService = tokenService;

        this.employeeRepository = employeeRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Entrei no filtro 2");
        String requestUri = request.getRequestURI().toString();
        var id = searchId(requestUri);
        var tokenJWT = recoverToken(request);
        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var user = employeeRepository.findByEmail(subject);
            System.out.println("teste" + id + user.get().getId());
            if (id != null && Long.parseLong(id) == user.get().getId()) {
              System.out.println("Deu certo a autenticação - id igual do token");
            }
        }
        System.out.println("Deu certo a autenticação - id diferente do token");
        filterChain.doFilter(request, response);
    }
    private String searchId(String requestUri) {
        List<String> url = Arrays.asList(requestUri.toString().split("/"));
        var index = url.indexOf("id");
        if (index != -1 && index + 1 < url.size()) {
            String id = url.get(index + 1);
            return id;
        } else {
            return null;
        }
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

}
