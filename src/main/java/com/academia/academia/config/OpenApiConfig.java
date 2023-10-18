package com.academia.academia.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Java 18 and Spring Boot 3")
                        .version("v1")
                        .description("Some description about your API")
                        .termsOfService("https://nordenacademy")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://nordenacademy")
                        )
                );
    }

}
