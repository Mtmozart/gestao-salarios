package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.AdminService;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
import org.hibernate.event.spi.SaveOrUpdateEvent;
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
    public ResponseEntity<String> createManage(@RequestBody CreateUsersRequestDto createUsersRequestDto){
        try{
            adminService.createManage(createUsersRequestDto);
            sendEmailCreateManager.send(createUsersRequestDto);
            return ResponseEntity.ok("Usuário criado com sucesso, em breve você receberá um e-mail com suas informações");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().body("Erro ao criar usuário." + ex.getMessage());
        }
    }

    @PostMapping("/create-employee")
    public ResponseEntity<String> createEmployee(@RequestBody CreateUsersRequestDto createUsersRequestDto){
        try{
            adminService.createEmployee(createUsersRequestDto);
            sendEmailCreateManager.send(createUsersRequestDto);
            return ResponseEntity.ok("Usuário criado com sucesso, em breve você receberá um e-mail com suas informações.");
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body("Erro ao criar usuário.");
        }
    }
    
}
