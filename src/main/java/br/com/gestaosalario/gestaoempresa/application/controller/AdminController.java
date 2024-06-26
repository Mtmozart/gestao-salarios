package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.AdminService;
import br.com.gestaosalario.gestaoempresa.dto.defaultResponse.DefaultMessage;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final SendEmailCreateManager sendEmailCreateManager;

    public AdminController(AdminService adminService, SendEmailCreateManager sendEmailCreateManager) {
        this.adminService = adminService;
        this.sendEmailCreateManager = sendEmailCreateManager;
    }

    @PostMapping("/create-manage")
    public ResponseEntity<DefaultMessage> createManage(@RequestBody @Valid CreateUsersRequestDto createUsersRequestDto) throws Exception, ManagerException {
        adminService.createManage(createUsersRequestDto);
        sendEmailCreateManager.send(createUsersRequestDto);
        var message = new DefaultMessage("Gerente criado com sucesso, em breve você receberá um e-mail com suas informações");
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/create-employee")
    public ResponseEntity<DefaultMessage> createEmployee(@RequestBody @Valid CreateUsersRequestDto createUsersRequestDto) throws Exception, ManagerException {
        adminService.createEmployee(createUsersRequestDto);
        sendEmailCreateManager.send(createUsersRequestDto);
            var message = new DefaultMessage("Empregado criado com sucesso, em breve você receberá um e-mail com suas informações.");
            return ResponseEntity.ok().body(message);
    }

}
