package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation.ValidationPayments;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final ManagerService managerService;
    private final EmployeeService employeeService;
    @Autowired
    private List<ValidationPayments> validations;


    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, ManagerService managerService, EmployeeService employeeService) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @Transactional
    public Boolean makePayment(PaymentRequestDTO paymentRequestDTO) throws Exception {
        try {
            var manager = managerService.findManageById(paymentRequestDTO.manageId());
            var employee = employeeService.searchEmployeeById(paymentRequestDTO.employeeId());
            var payment = paymentMapper.toPayment(manager, employee, paymentRequestDTO);
            var paymentSuccess = paymentRepository.save(payment);
            return true;
        } catch (ManagerException ex) {
            throw new ManagerException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }
}

