package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.Payment;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;

import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {

    public Payment toPayment(Manage manager, Employee employee, PaymentRequestDTO paymentRequestDTO) {

        return new Payment(
                manager,
                employee,
                paymentRequestDTO.price()
        );
    }

}
