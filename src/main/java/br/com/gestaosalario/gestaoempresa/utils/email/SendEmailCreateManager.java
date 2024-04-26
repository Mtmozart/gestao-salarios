package br.com.gestaosalario.gestaoempresa.utils.email;

import br.com.gestaosalario.gestaoempresa.domain.entities.user.User;
import br.com.gestaosalario.gestaoempresa.dto.manageDto.ManageRequestDto;
import org.springframework.stereotype.Component;

@Component
public class SendEmailCreateManager {
    private final SendEmail sendEmail;

    public SendEmailCreateManager(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

     public void send(ManageRequestDto manageRequestDto){
        sendEmail.sendEmail(
                "Create manager success.",
                manageRequestDto.email(),
                "Congratulations, " + manageRequestDto.name() + ", we have success in create your profile, your data for login\n: "
                        + "E-mail: " +    manageRequestDto.email() + " plus your password."
        );

         System.out.println("Email enviado.");
     }

}
