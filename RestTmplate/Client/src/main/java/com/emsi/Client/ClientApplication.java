package com.emsi.Client;

import com.emsi.Client.entities.Client;
import com.emsi.Client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null, "Bennis", 23f));
			clientRepository.save(new Client(null, "Mimani", 23f));
			clientRepository.save(new Client(null, "Naim", 23f));
			clientRepository.save(new Client(null, "Nam", 2f));
		};
	}
}
