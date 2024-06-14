package com.olympics.platform.u202212760.platform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        // General configuration
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("ESTO SE EDITA - U202212760")
                        .description("Modelo de Prueba examen UPC PC2 OPEN SOURCE MICHAEL.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("pc de prueba")
                        .url("https://acme-learning-platform.wiki.github.io/docs"));
        return openApi;
    }
}


//  URL SWAGGER:  http://localhost:8080/swagger-ui/index.html#/