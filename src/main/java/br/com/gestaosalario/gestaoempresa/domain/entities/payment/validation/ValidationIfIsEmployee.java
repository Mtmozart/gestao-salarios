package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation;

import br.com.gestaosalario.gestaoempresa.application.service.EmployeeService;
import br.com.gestaosalario.gestaoempresa.application.service.ManagerService;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import org.springframework.stereotype.Component;

@Component("ValidationIfIsEmployee")
public class ValidationIfIsEmployee implements ValidationPayments {
private final EmployeeRepository employeeRepository;

    public ValidationIfIsEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void validate(PaymentRequestDTO paymentRequestDTO) throws Exception {
        var employee = employeeRepository.searchEmployeeById(paymentRequestDTO.employeeId());
        if(!employee.getUser().getProfiles().contains(TypeProfile.ROLE_EMPLOYEE)){
            throw new Exception("Usuário sem permisão para receber o pagamento");
        }
    }
}
