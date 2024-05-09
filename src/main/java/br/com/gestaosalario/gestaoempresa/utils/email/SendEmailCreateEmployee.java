package br.com.gestaosalario.gestaoempresa.utils.email;

import br.com.gestaosalario.gestaoempresa.dto.usersDto.CreateUsersRequestDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendEmailCreateEmployee {
    private final SendEmail sendEmail;

    public SendEmailCreateEmployee(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Async("asyncEmail")
     public void send(CreateUsersRequestDto createUsersRequestDto){
        sendEmail.sendEmail(
                "Created employee success.",
                createUsersRequestDto.email(),
                "Congratulations, " + createUsersRequestDto.name() + ", we have success in create your profile, your data for login: \n "
                        + "E-mail: " +    createUsersRequestDto.email() + " plus your password."
        );

         System.out.println("Email has been sent.");
     }

}
