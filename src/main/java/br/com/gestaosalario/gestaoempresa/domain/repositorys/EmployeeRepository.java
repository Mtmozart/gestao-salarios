package br.com.gestaosalario.gestaoempresa.domain.repositorys;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
