package br.com.gestaosalario.gestaoempresa.domain.entities.user.validations.manager;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateManagerRequestDto;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import org.springframework.stereotype.Component;

@Component("TypeValidation")
public class TypeValidation implements ManagerValidations<CreateManagerRequestDto> {
    @Override
    public void validation(CreateManagerRequestDto data) {
        if (data.typeProfile().equals(TypeProfile.ROLE_MANAGER)) {
            throw new ManagerException("Tipo de perfil de usuário inválido.");
        }
    }
}
