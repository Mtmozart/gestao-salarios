package br.com.gestaosalario.gestaoempresa.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @PostMapping("/create")
    public String createUser(){
        return "Olá mundo.";
    }
}
