package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.application.service.EmployeeService;
import br.com.gestaosalario.gestaoempresa.application.service.ManagerService;
import br.com.gestaosalario.gestaoempresa.domain.entities.payment.Payment;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentResponseDTO;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class PaymentMapper {

    private final ManagerService managerService;
    private final EmployeeService employeeService;
    private LocalDateTime LocalDateTime;


    public PaymentMapper(ManagerService managerService, EmployeeService employeeService) {
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    public Payment toPayment(PaymentRequestDTO paymentRequestDTO){
        var manager = managerService.findManageById(paymentRequestDTO.manageId());
        var employee = employeeService.searchEmployeeById(paymentRequestDTO.employeeId());
        return new Payment(
                manager,
                employee,
                paymentRequestDTO.price()
        );
    }

   /* public PaymentResponseDTO toPaymentResponseDTO(Payment payment){
        return new PaymentResponseDTO(
                payment.getFromManage().getUser().getName(),
                payment.getToEmployee().getUser().getName(),
                payment.getPrice(),
                payment.getPaymentDate()
        );
    }*/
}
