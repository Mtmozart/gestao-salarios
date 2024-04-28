package br.com.gestaosalario.gestaoempresa.utils.email;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class SendEmailMakePayment {
    private final SendEmail sendEmail;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    public SendEmailMakePayment(SendEmail sendEmail, UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.sendEmail = sendEmail;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    public void send(PaymentRequestDTO paymentRequestDTO) {

        var employee = employeeRepository.findById(paymentRequestDTO.employeeId());
        var user = userRepository.findById(employee.get().getUser().getId());

        sendEmail.sendEmail(
                "Your received the payment.",
                user.get().getEmail(),
                "Your payment in the amount of " + paymentRequestDTO.price() + " has been successfully processed."

        );

        System.out.println("Email has been sent.");

    }

}
