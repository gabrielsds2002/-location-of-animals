package br.com.localizapets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
public class LocalizaPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalizaPetsApplication.class, args);
	}

}
