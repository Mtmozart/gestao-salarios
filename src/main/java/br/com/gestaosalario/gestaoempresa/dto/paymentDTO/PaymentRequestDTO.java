package br.com.gestaosalario.gestaoempresa.dto.paymentDTO;


import java.math.BigDecimal;

public record PaymentRequestDTO(Long manageId, Long employeeId, BigDecimal price) {
}
