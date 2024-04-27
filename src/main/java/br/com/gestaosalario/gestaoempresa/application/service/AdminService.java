package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.utils.mapper.ManageMapper;
import br.com.gestaosalario.gestaoempresa.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final ManageRepository manageRepository;
    private final ManageMapper manageMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmployeeRepository employeeRepository;


    public AdminService(ManageRepository manageRepository, ManageMapper manageMapper, UserRepository userRepository, UserMapper userMapper, EmployeeRepository employeeRepository) {
        this.manageRepository = manageRepository;
        this.manageMapper = manageMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void createManage(CreateUsersRequestDto createUsersRequestDto) {
        var user = userMapper.toUser(createUsersRequestDto);
        user.setProfiles(user.getProfiles());
        userRepository.save(user);
        var manager = new Manage(user);
        manageRepository.save(manager);
    }

    @Transactional
    public void createEmployee(CreateUsersRequestDto createUsersRequestDto) {
        var user = userMapper.toUser(createUsersRequestDto);
        user.setProfiles(user.getProfiles());
        userRepository.save(user);
        var emplooyee = new Employee(user);
        employeeRepository.save(emplooyee);
    }


    @Transactional
    private void saveProfile() {

    }
}
