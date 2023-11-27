package com.allin.Allin;

import com.allin.Allin.Entity.Enum.Role;
import com.allin.Allin.Service.AuthenticationService;
import com.allin.Allin.dto.Request.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

import static com.allin.Allin.Entity.Enum.Role.ADMIN;
import static com.allin.Allin.Entity.Enum.Role.MANAGER;

@SpringBootApplication
public class AllinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllinApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@gmail.com")
					.password("12345")
					.role(ADMIN)
					.build();
			System.out.println("Admintoken: " + service.register(admin).getToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("adnmi@gmail.com")
					.password("123457")
					.role(MANAGER)
					.build();
			System.out.println("Managertoken: " + service.register(manager).getToken());
		};
	}
}
