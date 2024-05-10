package br.com.gestaosalario.gestaoempresa.application.service;


import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.validations.general.GeneralValidations;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentResponseDTO;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;




    public EmployeeService(EmployeeRepository employeeRepository, PaymentRepository paymentRepository, UserRepository userRepository, PaymentMapper paymentMapper) {
        this.employeeRepository = employeeRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    public List<PaymentResponseDTO> allPayments(Long id) {
        List<PaymentResponseDTO> response = new ArrayList<>();
        var employee = searchEmployeeById(id);
        var payments = paymentRepository.findAllByToEmployee(employee);
        if (payments.isEmpty()) {
            return null;
        }
        return payments.stream()
                .map(p -> new PaymentResponseDTO(
                        p.getToEmployee().getUser().getName(),
                        p.getToEmployee().getUser().getName(),
                        p.getPrice(),
                        p.getPaymentDate()
                ))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<PaymentResponseDTO> paymentByMonth(Long id, String month) {
        var employee = searchEmployeeById(id);
        try {
            var payments = paymentRepository.findAllByToEmployee(employee);
            if (!payments.isEmpty()) {
                return payments.stream()
                        .filter(p -> p.getPaymentDate().getMonth().toString().equalsIgnoreCase(month))
                        .map(p -> new PaymentResponseDTO(
                                p.getToEmployee().getUser().getName(),
                                p.getToEmployee().getUser().getName(),
                                p.getPrice(),
                                p.getPaymentDate()
                        ))
                        .collect(Collectors.toUnmodifiableList());
            }
            return Collections.emptyList();

        } catch (ManagerException ex) {
            throw new ManagerException(ex.getMessage());
        }
    }

    public Employee searchEmployeeById(Long id) {
        var employee = employeeRepository.searchEmployeeById(id);
        if (employee == null) {
            throw new ManagerException("Erro ao pesquisar o usuário.");
        }
        return employee;
    }

}
