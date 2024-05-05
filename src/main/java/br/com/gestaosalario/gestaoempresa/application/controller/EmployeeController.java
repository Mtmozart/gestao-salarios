package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.EmployeeService;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/payments/{id}")
    public ResponseEntity<List<PaymentResponseDTO>> allPayments(@PathVariable Long id) {
        List<PaymentResponseDTO> payments = employeeService.allPayments(id);
        if (payments != null) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/payments/{id}/{month}")
    public ResponseEntity<List<PaymentResponseDTO>> paymentByMonth(@PathVariable Long id, @PathVariable  String month) {
        List<PaymentResponseDTO> payments = employeeService.paymentByMonth(id, month);
        if (!payments.isEmpty()) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
