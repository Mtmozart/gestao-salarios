package br.com.gestaosalario.gestaoempresa.dto.manageDto;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;

public record CreateUsersRequestDto(String name, String email, String password, TypeProfile typeProfile) {
}
