package br.com.localizapets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LocalizaPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalizaPetsApplication.class, args);
	}

}
