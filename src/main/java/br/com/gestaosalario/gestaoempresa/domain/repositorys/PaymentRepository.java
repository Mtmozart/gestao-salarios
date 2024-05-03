package br.com.gestaosalario.gestaoempresa.domain.repositorys;

import br.com.gestaosalario.gestaoempresa.domain.entities.payment.Payment;
import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findAllByToEmployee(User user);
}
