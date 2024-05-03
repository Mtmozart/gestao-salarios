package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final ManagerService managerService;
    private final EmployeeService employeeService;


    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, ManagerService managerService, EmployeeService employeeService) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @Transactional
    public Boolean makePayment(PaymentRequestDTO paymentRequestDTO){
        var manager = managerService.findManageById(paymentRequestDTO.manageId());
        var employee = employeeService.searchEmployeeById(paymentRequestDTO.employeeId());
        var payment = paymentMapper.toPayment(manager, employee, paymentRequestDTO);
        var paymentSuccess = paymentRepository.save(payment);
        if (paymentSuccess == null){
            return false;
        }
        return true;
    }
}
