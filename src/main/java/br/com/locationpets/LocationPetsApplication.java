package br.com.locationpets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LocationPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationPetsApplication.class, args);
	}

}
