package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.validations.general.GeneralValidations;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.validations.manager.ManagerValidations;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.EmployeeRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import br.com.gestaosalario.gestaoempresa.infra.security.EncryptPassword;
import br.com.gestaosalario.gestaoempresa.utils.mapper.ManageMapper;
import br.com.gestaosalario.gestaoempresa.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Service
public class AdminService {

    private final ManageRepository manageRepository;
    private final ManageMapper manageMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmployeeRepository employeeRepository;
    private final EncryptPassword encryptPassword;
    @Autowired
    private List<GeneralValidations> generalValidations;
    @Autowired
    private List<ManagerValidations> managerValidations;
    @Autowired
    private SecurityType securityType;


    public AdminService(ManageRepository manageRepository, ManageMapper manageMapper, UserRepository userRepository, UserMapper userMapper, EmployeeRepository employeeRepository, EncryptPassword encryptPassword) {
        this.manageRepository = manageRepository;
        this.manageMapper = manageMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.employeeRepository = employeeRepository;
        this.encryptPassword = encryptPassword;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void createManage(CreateUsersRequestDto createUsersRequestDto) {
        generalValidations.forEach(g -> g.validation(createUsersRequestDto));
        securityType.securityType(createUsersRequestDto, TypeProfile.ROLE_MANAGER);
        var user = userMapper.toUser(createUsersRequestDto);
        user.setProfiles(user.getProfiles());
        user.setPassword(encryptPassword.encrypt(createUsersRequestDto.password()));
        userRepository.save(user);
        var manager = new Manage(user);
        manageRepository.save(manager);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void createEmployee(CreateUsersRequestDto createUsersRequestDto) {
        generalValidations.forEach(g -> g.validation(createUsersRequestDto));
        securityType.securityType(createUsersRequestDto, TypeProfile.ROLE_EMPLOYEE);
        var user = userMapper.toUser(createUsersRequestDto);
        user.setProfiles(user.getProfiles());
        user.setPassword(encryptPassword.encrypt(createUsersRequestDto.password()));
        userRepository.save(user);
        var employee = new Employee(user);
        employeeRepository.save(employee);
    }

}



