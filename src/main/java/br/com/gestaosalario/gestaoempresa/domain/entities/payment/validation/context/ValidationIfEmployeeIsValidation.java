package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation.context;

import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.infra.security.RecoverToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("ValidationIfEmployeeIsValidation")
public class ValidationIfEmployeeIsValidation implements ValidationContext {
private final EmployeeRepository employeeRepository;
private final RecoverToken recoverToken;

    public ValidationIfEmployeeIsValidation(EmployeeRepository employeeRepository, RecoverToken recoverToken) {
        this.employeeRepository = employeeRepository;
        this.recoverToken = recoverToken;
    }

    @Override
    public void validate(Authentication authentication) throws Exception {
       Object principal = authentication.getName();

    }
}
