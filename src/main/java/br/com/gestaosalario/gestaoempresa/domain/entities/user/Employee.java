package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private Profile profile;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Payment> paymentsReceived = new ArrayList<>();
}
