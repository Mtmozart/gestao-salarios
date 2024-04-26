package br.com.gestaosalario.gestaoempresa.application.controller;

import br.com.gestaosalario.gestaoempresa.application.service.AdminService;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.ManageRequestDto;
import br.com.gestaosalario.gestaoempresa.utils.email.SendEmailCreateManager;
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
    public String createManage(@RequestBody ManageRequestDto manageRequestDto){
        try{
            adminService.createManage(manageRequestDto);
            sendEmailCreateManager.send(manageRequestDto);
            return "Sucesso.";
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
