package br.com.rsds.sigame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.sigame.enums.Category;
import br.com.rsds.sigame.enums.Type;
import br.com.rsds.sigame.model.Sigame;
import br.com.rsds.sigame.repository.SigaMeRepository;

@SpringBootApplication
public class SigaMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigaMeApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(SigaMeRepository sigaMeRepository) {

		return args -> {
			sigaMeRepository.deleteAll();
			Sigame sigaMe = new Sigame();
			sigaMe.setName("6000");
			sigaMe.setType(Type.PERMANENTE);
			sigaMe.setCategory(Category.PARCIAL);
			sigaMe.setStatus("Aberto");
			sigaMe.setRamal("6000");
			sigaMe.setDestiny("6001");
			sigaMeRepository.save(sigaMe);
		};
	}
}
