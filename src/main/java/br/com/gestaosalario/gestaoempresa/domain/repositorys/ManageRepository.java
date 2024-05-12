package br.com.gestaosalario.gestaoempresa.domain.repositorys;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManageRepository extends JpaRepository<Manage, Long> {
    @Query("SELECT m FROM Manage m WHERE m.id = :manageId")
    Manage SearchManageByManageId(Long manageId);


}
