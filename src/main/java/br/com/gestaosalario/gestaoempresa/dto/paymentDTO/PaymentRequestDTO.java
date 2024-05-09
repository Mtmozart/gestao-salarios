package br.com.gestaosalario.gestaoempresa.dto.paymentDTO;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotNull(message = "{manageId.mandatory}")
        Long manageId,
        @NotNull(message = "{employeeId.mandatory}")
        Long employeeId,
        @NotNull(message = "{price.mandatory}")
        @DecimalMin(value = "0", inclusive = true, message = "{price.min}")
        @Digits(integer = 100, fraction = 2, message = "{price.totalDigits}")
        BigDecimal price) {
}
