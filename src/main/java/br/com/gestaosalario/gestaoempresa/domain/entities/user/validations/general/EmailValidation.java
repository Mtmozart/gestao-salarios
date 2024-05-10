package br.com.gestaosalario.gestaoempresa.domain.entities.user.validations.general;

import br.com.gestaosalario.gestaoempresa.domain.repositorys.UserRepository;
import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import br.com.gestaosalario.gestaoempresa.infra.exception.ManagerException;
import org.springframework.stereotype.Component;

@Component("EmailValidation")
public class EmailValidation implements GeneralValidations<CreateUsersRequestDto>{

    private final UserRepository userRepository;

    public EmailValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void validation(CreateUsersRequestDto data) {
        var user = userRepository.findUserByEmailReturnUser(data.email());
        if(user != null){
            throw new ManagerException("E-mail já cadastrado.");
        }
    }
}
