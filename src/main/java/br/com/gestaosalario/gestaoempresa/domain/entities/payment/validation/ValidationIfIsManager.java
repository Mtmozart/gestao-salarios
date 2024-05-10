package br.com.gestaosalario.gestaoempresa.domain.entities.payment.validation;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.TypeProfile;
import br.com.gestaosalario.gestaoempresa.domain.repositorys.ManageRepository;
import br.com.gestaosalario.gestaoempresa.dto.paymentDTO.PaymentRequestDTO;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import org.springframework.stereotype.Component;

@Component("ValidationIfIsManager")
public class ValidationIfIsManager implements ValidationPayments {
    private final ManageRepository manageRepository;

    public ValidationIfIsManager(ManageRepository manageRepository) {
        this.manageRepository = manageRepository;
    }
    @Override
    public void validate(PaymentRequestDTO paymentRequestDTO) {
        var manager = manageRepository.SearchManageByManageId(paymentRequestDTO.manageId());
        if(!manager.getUser().getProfiles().toString().contains(TypeProfile.ROLE_MANAGER.toString())){
            throw new ManagerException("Usuário sem permisão para fazer o pagamento");
        }
    }
}
