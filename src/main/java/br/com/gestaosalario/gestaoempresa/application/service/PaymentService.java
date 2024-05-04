package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation.ValidationPayments;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final ManagerService managerService;
    private final EmployeeService employeeService;
    private List<ValidationPayments> validations;



    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, ManagerService managerService, EmployeeService employeeService, List<ValidationPayments> validations) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.managerService = managerService;
        this.employeeService = employeeService;
        this.validations = validations;
    }

    @Transactional
    public Boolean makePayment(PaymentRequestDTO paymentRequestDTO) throws Exception {
        validations.forEach(v -> {
            try {
                v.validate(paymentRequestDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        var manager = managerService.findManageById(paymentRequestDTO.manageId());
        if(manager == null){
            throw new Exception("Gerente não encontrado");
        }
        var employee = employeeService.searchEmployeeById(paymentRequestDTO.employeeId());
        if(employee == null){
            throw new Exception("Empregado não encontrado");
        }
        var payment = paymentMapper.toPayment(manager, employee, paymentRequestDTO);
        var paymentSuccess = paymentRepository.save(payment);
        if (paymentSuccess == null){
            return false;
        }
        return true;
    }
}
