package br.com.localizapets.config.security;

import br.com.localizapets.exceptions.RetreiveMessageErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;


public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }
}
