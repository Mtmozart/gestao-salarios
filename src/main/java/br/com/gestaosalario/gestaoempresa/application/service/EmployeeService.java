package br.com.gestaosalario.gestaoempresa.application.service;


import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentResponseDTO;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<PaymentResponseDTO> allPayments(Long id){
        List<PaymentResponseDTO> response = new ArrayList<>();
        var employee = searchEmployeeById(id);
        var payments = paymentRepository.findAllByToEmployee(employee);
        if (payments.isEmpty()){
            return null;
        }
        return payments.stream()
                .map(p -> new PaymentResponseDTO(
                        p.getToEmployee().getUser().getName(),
                        p.getToEmployee().getUser().getName(),
                        p.getPrice(),
                        p.getPaymentDate()
                ))
                .collect(Collectors.toList());
    }
    public Employee searchEmployeeById(Long id) {
        var employee = employeeRepository.searchEmployeeById(id);
        if (employee == null) {
            System.out.println("Erro ao pesquisar o empregado.");
            return null;
        }
        return employee;
    }

}