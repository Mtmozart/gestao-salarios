package br.com.gestaosalario.gestaoempresa.utils.mapper;

import br.com.gestaosalario.gestaoempresa.application.service.ProfileService;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Profile;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
private final ProfileService profileService;

    public ProfileMapper(ProfileService profileService) {
        this.profileService = profileService;
    }

    public Profile toProfile(TypeProfile typeProfile){
       return profileService.searchProfile(typeProfile);

    }
}
