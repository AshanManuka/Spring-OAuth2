package com.amSecurity.amSecurity;

import com.amSecurity.amSecurity.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AmSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmSecurityApplication.class, args);
	}

}
