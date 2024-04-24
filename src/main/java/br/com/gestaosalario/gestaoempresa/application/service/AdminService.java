package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.ManageRequestDto;
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


    public AdminService(ManageRepository manageRepository, ManageMapper manageMapper, UserRepository userRepository, UserMapper userMapper) {
        this.manageRepository = manageRepository;
        this.manageMapper = manageMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public void createManage(ManageRequestDto manageRequestDto) {
        var user = userRepository.save(userMapper.toUser(manageRequestDto));
        var manager = new Manage(user);
        manageRepository.save(manager);
    }


    @Transactional
    private void saveProfile() {

    }
}
