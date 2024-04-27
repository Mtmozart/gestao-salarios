package br.com.gestaosalario.gestaoempresa.utils.mapper;


import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.CreateUsersRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ManageMapper {

private final UserMapper userMapper;

    public ManageMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public Manage toManageCreate(CreateUsersRequestDto manageDTO) {
        var user = userMapper.toUser(manageDTO);
        return new Manage(user);
    }

}
