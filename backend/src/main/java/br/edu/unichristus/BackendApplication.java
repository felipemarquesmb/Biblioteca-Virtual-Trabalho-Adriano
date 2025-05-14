package br.edu.unichristus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Biblioteca Virtual",
				version = "1.0",
				description = "Backend da Aplicação Construída na Disciplina TE",
				contact = @Contact(
						name = "MUDAAAAAAAAAAAAAAAAAAAAAAARRRRRRRR",
						email = "analista.adrianolima@gmail.com",
						url = "http://unichristus.edu.br/")
		)
)
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
