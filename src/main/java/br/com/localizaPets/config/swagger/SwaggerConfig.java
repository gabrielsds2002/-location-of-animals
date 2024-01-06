package br.com.localizapets.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket aluraApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bastos.aluraflix"))
//                .paths(PathSelectors.ant("/**"))
//                .build()
//                .ignoredParameterTypes(UsuarioEntity.class)
//                .globalOperationParameters(List.of(
//                        new ParameterBuilder()
//                                .name("Authorization")
//                                .description("Header para token JWT")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(false)
//                                .build()));
//    }
//}
