package br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;

import java.math.BigDecimal;

public record PaymentRequestDTO(Long manageId, Long employeeId, BigDecimal price) {
}
