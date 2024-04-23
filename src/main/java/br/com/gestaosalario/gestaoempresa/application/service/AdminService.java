package br.com.gestaosalario.gestaoempresa.application.service;

import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.dtos.manageDtos.ManageRequestDto;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final ManageRepository manageRepository;

    public AdminService(ManageRepository manageRepository) {
        this.manageRepository = manageRepository;
    }

    @Transactional
   public void createManage(ManageRequestDto manageRequestDto){

   }
}
