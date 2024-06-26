package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import org.springframework.stereotype.Component;

@Component("ValidationIfIsEmployee")
public class ValidationIfIsEmployee implements ValidationPayments {
private final EmployeeRepository employeeRepository;

    public ValidationIfIsEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void validate(PaymentRequestDTO paymentRequestDTO) {
        var employee = employeeRepository.searchEmployeeById(paymentRequestDTO.employeeId());
        System.out.println(employee.getUser().getProfiles().toString());
        if(!employee.getUser().getProfiles().toString().contains(TypeProfile.ROLE_EMPLOYEE.toString())){
            throw new ManagerException("Usuário sem permisão para receber o pagamento");
        }
    }
}
