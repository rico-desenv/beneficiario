package com.saude.beneficiario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.saude.beneficiario.entities.User;
import com.saude.beneficiario.repositories.UserRepository;

@SpringBootApplication
public class BeneficiarioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioApplication.class, args);
	}	

	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			var user = new User();
			user.setId(1);
			user.setEmail("usuario01@mail.com");
			user.setPass(encoder.encode("123"));
			//users.save(user);
			//clientes.save(new Cliente("1234567889", "cliente 01111", "Analista", "cliente01111@mail.com", "11 99999999"));
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}
}
