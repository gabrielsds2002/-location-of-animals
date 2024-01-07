package br.com.localizapets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
public class LocalizaPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalizaPetsApplication.class, args);
	}

}
