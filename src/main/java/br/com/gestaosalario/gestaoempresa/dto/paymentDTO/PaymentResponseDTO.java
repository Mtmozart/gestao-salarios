package br.com.gestaosalario.gestaoempresa.dto.paymentDTO;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponseDTO(String nameManage, String nameEmployee, BigDecimal value, LocalDateTime date) {
}
