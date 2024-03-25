package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Profile {
    private Long id;
    private TypeProfile type;
}
