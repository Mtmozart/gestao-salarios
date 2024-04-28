package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee searchEmployeeById(Long id){
        var employee = employeeRepository.searchEmployeeById(id);
        if(employee == null){
            System.out.println("Erro ao pesquisar o empregado.");
            return null;
        }
        return employee;
    }

}
