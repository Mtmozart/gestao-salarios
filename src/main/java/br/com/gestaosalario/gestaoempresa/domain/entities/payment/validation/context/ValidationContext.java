package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation.context;


import org.springframework.security.core.Authentication;
public interface ValidationContext {
    void validate(Authentication authentication) throws Exception;
}
