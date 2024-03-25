package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Payment {
    private Long value;
    private LocalDateTime date;
    private Employee employee;

}
