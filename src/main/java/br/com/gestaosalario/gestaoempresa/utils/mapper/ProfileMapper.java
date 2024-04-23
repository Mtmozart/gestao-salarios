package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Profile;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.ManageRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile toProfile(TypeProfile typeProfile){
       return new Profile(typeProfile);
    }
}
