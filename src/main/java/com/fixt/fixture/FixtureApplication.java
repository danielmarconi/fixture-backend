package com.fixt.fixture;

import com.fixt.fixture.Services.ServiceFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FixtureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixtureApplication.class, args);
	}

	@Autowired
	private ServiceFixture serviceFixture;

	@Bean
	public CommandLineRunner initilizeDB() {
		return x -> serviceFixture.inicializarBaseDeDatos();
	}

}
