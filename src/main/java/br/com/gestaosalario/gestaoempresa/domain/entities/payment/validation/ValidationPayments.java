package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation;

import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;

public interface ValidationPayments {
    void validate(PaymentRequestDTO paymentRequestDTO) throws Exception;
}
