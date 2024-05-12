package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ProfileMapper profileMapper;


    public UserMapper(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public User toUser(CreateUsersRequestDto createUsersRequestDto) {
        return new User(
                createUsersRequestDto.name(),
                createUsersRequestDto.email(),
                createUsersRequestDto.password(),
                profileMapper.toProfile(createUsersRequestDto.typeProfile()));
    }

}
