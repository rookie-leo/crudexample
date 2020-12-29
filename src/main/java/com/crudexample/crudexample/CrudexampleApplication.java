package com.crudexample.crudexample;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crudexample.models.Contato;
import com.crudexample.repository.ContatoRepository;

@SpringBootApplication
public class CrudexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudexampleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContatoRepository cr) {
		return args -> {
			cr.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Contato c = new Contato();
						c.setNome("Contato" + i);
						c.setEmail("contato" + i + "@email.com");
						c.setFone("(11)1234-5678");
						return c;
					})
					.map(v -> cr.save(v))
					.forEach(System.out::println);
		};
	}
}
