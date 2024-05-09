package br.com.gestaosalario.gestaoempresa.infra.security;

import br.com.gestaosalario.gestaoempresa.application.service.TokenService;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


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
        String requestUri = request.getRequestURI();
        var id = searchId(requestUri);
        if(id == null){
            filterChain.doFilter(request, response);
            return;
        }
        var tokenJWT = recoverToken(request);
        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var user = employeeRepository.findById(Long.parseLong(id));
            if (user.get().getUser().getEmail().equals(subject)) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Acesso proibido");
    }

    private String searchId(String requestUri) {
        List<String> url = Arrays.asList(requestUri.split("/"));
        var index = url.indexOf("id");
        if (index != -1 && index + 1 < url.size()) {
            return url.get(index + 1);

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
