package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import org.springframework.stereotype.Component;

@Component
public class SecurityType {
    protected void securityType(CreateUsersRequestDto data, TypeProfile typeProfile){
        if(!typeProfile.equals(data.typeProfile())) {
            throw new ManagerException("Tipagem de usuário incorreta, verifique o tipo de usuário que deseja criar");
        }
    }
}
