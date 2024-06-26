package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.ManagerService;
import br.com.gestaosalario.gestaoempresa.application.service.PaymentService;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailMakePayment;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manage")
public class ManageController {
    private final ManagerService managerService;
    private final SendEmailCreateManager sendEmailCreateManager;
    private final PaymentService paymentService;
    private final SendEmailMakePayment sendEmailMakePayment;


    public ManageController(ManagerService managerService, SendEmailCreateManager sendEmailCreateManager, PaymentService paymentService, SendEmailMakePayment sendEmailMakePayment) {
        this.managerService = managerService;
        this.sendEmailCreateManager = sendEmailCreateManager;
        this.paymentService = paymentService;
        this.sendEmailMakePayment = sendEmailMakePayment;
    }

    @PostMapping("/create-employee")
    public ResponseEntity<String> createEmployee(@RequestBody @Valid CreateUsersRequestDto createUsersRequestDto) throws Exception, ManagerException {
        managerService.createEmployee(createUsersRequestDto);
        sendEmailCreateManager.send(createUsersRequestDto);
        return ResponseEntity.ok("Usuário criado com sucesso, em breve você receberá um e-mail com suas informações");
    }

    @PostMapping("/make-payment")
    public ResponseEntity<String> makePayment(@RequestBody @Valid PaymentRequestDTO paymentRequestDTO) throws Exception, ManagerException {
        var payment = paymentService.makePayment(paymentRequestDTO);
        System.out.println("Thread do controller manage: " + Thread.currentThread().getName());
        sendEmailMakePayment.send(paymentRequestDTO);
        return ResponseEntity.ok("Pagamento realizado com sucesso, em breve enviaremos um comprovante.");
    }
}
