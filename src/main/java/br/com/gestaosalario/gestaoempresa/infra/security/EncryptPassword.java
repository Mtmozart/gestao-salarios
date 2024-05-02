package br.com.gestaosalario.gestaoempresa.infra.security;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class EncryptPassword {
     public String encrypt(String password){
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         return bCryptPasswordEncoder.encode(password);
    }
}
