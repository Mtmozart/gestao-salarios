package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Employee {
    private Long id;
    private User user;
    private List<Payment> payments;
}
