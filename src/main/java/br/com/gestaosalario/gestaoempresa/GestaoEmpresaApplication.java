package br.com.gestaosalario.gestaoempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GestaoEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoEmpresaApplication.class, args);
	}

}
