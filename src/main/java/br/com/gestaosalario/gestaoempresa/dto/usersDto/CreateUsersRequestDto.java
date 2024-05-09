package br.com.gestaosalario.gestaoempresa.dto.usersDto;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateUsersRequestDto(
        @NotBlank(message = "{name.mandatory}")
        String name,
        @NotBlank(message = "{email.mandatory}") @Email(message = "{email.invalid}")
        String email,
        @NotBlank(message = "{password.mandatory}")
        @Pattern(regexp = "^^(?=.*[a-z])(?=.*[\\d@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$")
        String password,
        @NotBlank(message = "{typeProfile.mandatory}")
        TypeProfile typeProfile) {
}
