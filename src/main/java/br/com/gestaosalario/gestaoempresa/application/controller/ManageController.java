package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.ManagerService;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.dto.paymentResquestDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manage")
public class ManageController {
    private final ManagerService managerService;
    private final SendEmailCreateManager sendEmailCreateManager;

    public ManageController(ManagerService managerService, SendEmailCreateManager sendEmailCreateManager) {
        this.managerService = managerService;
        this.sendEmailCreateManager = sendEmailCreateManager;
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

    public void makePayment(PaymentRequestDTO paymentRequestDTO) {

    }
}
