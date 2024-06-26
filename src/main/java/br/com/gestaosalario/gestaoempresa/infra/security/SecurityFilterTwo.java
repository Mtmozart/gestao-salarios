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
        if (id == null) {
            filterChain.doFilter(request, response);
            return;
        }
        var tokenJWT = tokenService.recoverToken(request);
        try {
            if (tokenJWT != null) {
                var subject = tokenService.getSubject(tokenJWT);
                var user = employeeRepository.findById(Long.parseLong(id));
                if (!user.get().getUser().getEmail().equals(subject)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{ \"error\": \" Acesso negado!\" }");
                   return;
                }
                filterChain.doFilter(request, response);

            }
        } catch (RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{ \"error\": \"" + e.getMessage() + "\" }");
        }
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

  }
