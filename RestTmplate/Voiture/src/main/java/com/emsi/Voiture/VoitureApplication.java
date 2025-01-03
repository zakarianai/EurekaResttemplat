package com.emsi.Voiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.emsi.Voiture.service")
public class VoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository) {
//		return args -> {
//			voitureRepository.save(new Voiture(null, "2B", "Mercedes", "AMG", 1L, new Client(1L, "Bennis", 24f)));
//		};
//	}

//	@Bean
//	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientServiceFeignClient clientService){
//
//		return args -> {
//			Client c1 = clientService.clientById(2L);
//			Client c2 = clientService.clientById(1L);
//			System.out.println("************************");
//			System.out.println("Id est :" + c2.getId());
//			System.out.println("Nom est :" + c2.getNom());
//			System.out.println("************************");
//			System.out.println("************************");
//			System.out.println("Id est :" + c1.getId());
//			System.out.println("Nom est :" + c1.getNom());
//			System.out.println("Age est :" + c1.getAge());
//			System.out.println("************************");
//			voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", 1L, c2));
//			voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
//			voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));
//		};
//	}
	@Bean
    public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new
				SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate. setRequestFactory (requestFactory);
		return restTemplate;

    }

}
