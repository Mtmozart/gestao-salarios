package br.com.gestaosalario.gestaoempresa.domain.entities.payment;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "fromManage")
    private Manage fromManage;
    @ManyToOne
    @JoinColumn(name = "toEmployee")
    private Employee toEmployee;
    private BigDecimal price;
    private LocalDateTime paymentDate;
}
