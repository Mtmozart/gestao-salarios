package br.com.gestaosalario.gestaoempresa.dto.loginDataDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank(message = "{email.mandatory}") @Email(message = "{email.invalid}")
        String email,

        @NotBlank(message = "{password.mandatory}")
        String password) {
}
