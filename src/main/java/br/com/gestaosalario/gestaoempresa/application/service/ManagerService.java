package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.utils.mapper.ManageMapper;
import br.com.gestaosalario.gestaoempresa.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmployeeRepository employeeRepository;

    public ManagerService(UserRepository userRepository, UserMapper userMapper, EmployeeRepository employeeRepository) {
         this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void createEmployee(CreateUsersRequestDto createUsersRequestDto) {
        var user = userMapper.toUser(createUsersRequestDto);
        user.setProfiles(user.getProfiles());
        userRepository.save(user);
        var emplooyee = new Employee(user);
        employeeRepository.save(emplooyee);
    }
}
