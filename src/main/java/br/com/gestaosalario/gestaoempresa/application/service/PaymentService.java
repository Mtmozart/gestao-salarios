package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.Payment;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;


    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Transactional
    public Boolean makePayment(PaymentRequestDTO paymentRequestDTO){
        var payment = paymentMapper.toPayment(paymentRequestDTO);
        var paymentSuccess = paymentRepository.save(payment);
        if (paymentSuccess == null){
            return false;
        }
        return true;
    }
}
