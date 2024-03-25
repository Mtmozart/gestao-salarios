package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Profile profile;

}
