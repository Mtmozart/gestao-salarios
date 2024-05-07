package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation.context;

import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.infra.security.ComparingTokenAndUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("ValidationIfEmployeeIsValidation")
public class ValidationIfEmployeeIsValidation implements ValidationContext {
private final EmployeeRepository employeeRepository;
private final ComparingTokenAndUser comparingTokenAndUser;

    public ValidationIfEmployeeIsValidation(EmployeeRepository employeeRepository, ComparingTokenAndUser comparingTokenAndUser) {
        this.employeeRepository = employeeRepository;
        this.comparingTokenAndUser = comparingTokenAndUser;
    }

    @Override
    public void validate(Authentication authentication) throws Exception {
        Object principal = authentication.getName();
    }
}
