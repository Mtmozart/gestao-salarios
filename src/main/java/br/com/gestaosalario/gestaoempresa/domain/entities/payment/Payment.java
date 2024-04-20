package br.com.gestaosalario.gestaoempresa.domain.entities.payment;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
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
    @JoinColumn(name = "fromUser")
    private User fromUser;
    @ManyToOne
    @JoinColumn(name = "toUser")
    private User toUser;
    private BigDecimal price;
    private LocalDateTime paymentDate;
}
