package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.EmployeeService;
import br.com.gestaosalario.gestaoempresa.application.service.ManagerService;
import br.com.gestaosalario.gestaoempresa.application.service.PaymentService;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailMakePayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manage")
public class ManageController {
    private final ManagerService managerService;
    private final SendEmailCreateManager sendEmailCreateManager;
    private final EmployeeService employeeService;
    private final PaymentService paymentService;
    private final SendEmailMakePayment sendEmailMakePayment;


    public ManageController(ManagerService managerService, SendEmailCreateManager sendEmailCreateManager, EmployeeService employeeService, PaymentService paymentService, SendEmailMakePayment sendEmailMakePayment) {
        this.managerService = managerService;
        this.sendEmailCreateManager = sendEmailCreateManager;
        this.employeeService = employeeService;
        this.paymentService = paymentService;
        this.sendEmailMakePayment = sendEmailMakePayment;
    }

    @PostMapping("/create-employee")
    public ResponseEntity<String> createEmployee(@RequestBody CreateUsersRequestDto createUsersRequestDto) {
        try {
            managerService.createEmployee(createUsersRequestDto);
            sendEmailCreateManager.send(createUsersRequestDto);
            return ResponseEntity.ok("Usuário criado com sucesso, em breve você receberá um e-mail com suas informações");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro ao criar usuário.");
        }
    }

    @PostMapping("/make-payment")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
       try {
           paymentService.makePayment(paymentRequestDTO);
           sendEmailMakePayment.send(paymentRequestDTO);
           return ResponseEntity.ok("Pagamento realizado com sucesso, em breve enviaremos um comprovante.");
       }
       catch (Exception ex){
           System.out.println(ex.getMessage());
           return ResponseEntity.badRequest().body("Erro ao Realizar o pagamento.");
       }
    }
}
