package br.com.gestaosalario.gestaoempresa.domain.repositorys;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Employee searchEmployeeById(Long id);
}
