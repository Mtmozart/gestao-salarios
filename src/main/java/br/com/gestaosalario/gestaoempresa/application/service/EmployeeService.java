package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.Payment;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.PaymentRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentResponseDTO;
import br.com.gestaosalario.gestaoempresa.utils.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    //private final PaymentMapper paymentMapper;

    public EmployeeService(EmployeeRepository employeeRepository, PaymentRepository paymentRepository, UserRepository userRepository, PaymentMapper paymentMapper) {
        this.employeeRepository = employeeRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
       // this.paymentMapper = paymentMapper;
    }


    public List<PaymentResponseDTO> seePayment(@PathVariable Long id) {
        var user = userRepository.findById(id);
        List<Payment> payments = new ArrayList<>();

       /* payments.stream()
                .map(payment -> paymentMapper.toPaymentResponseDTO(
                                payment
                        )
                ).collect(Collectors.toList());*/
        return null;
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
