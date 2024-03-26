package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class Profile {
    private Long id;
    private TypeProfile type;
}
