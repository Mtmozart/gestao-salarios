package br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;

import java.math.BigDecimal;

public record PaymentRequestDTO(Manage manage, Employee employee, BigDecimal price) {

}
