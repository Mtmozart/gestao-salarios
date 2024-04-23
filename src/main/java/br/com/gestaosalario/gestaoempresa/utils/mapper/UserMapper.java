package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.ManageRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ProfileMapper profileMapper;


    public UserMapper(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public User fromManageToUser(Manage manage) {
        return manage.getUser();
    }

    public User toUser(ManageRequestDto manageRequestDto) {
        return new User(
                manageRequestDto.name(),
                manageRequestDto.email(),
                manageRequestDto.password(),
                profileMapper.toProfile(manageRequestDto.typeProfile()));
    }

}
