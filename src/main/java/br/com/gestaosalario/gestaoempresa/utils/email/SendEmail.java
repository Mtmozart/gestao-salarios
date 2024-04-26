package br.com.gestaosalario.gestaoempresa.utils.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
    private final JavaMailSender emailSender;

    public SendEmail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(String subject, String from, String messageText) {
        try {
            var email = new SimpleMailMessage();
            email.setFrom("bmozart.dev@gmail.com");
            email.setSubject(subject);
            email.setTo(from);
            email.setText(messageText);
            emailSender.send(email);
//            System.out.println("Enviando email!");
//            System.out.println(textoEmail);

            //Simulando demora de 3 segundos para enviar email
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email!" + e.getMessage());
        }
    }
}
