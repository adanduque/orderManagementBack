package com.orderServices.micro_serv_oders.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Adan Smith Duque Aquino",
                        email = "smith.asda87@gmail.com",
                        url = "https://www.linkedin.com/in/adan-duque/"
                ),
                description = "Rest Api on orders microservice",
                title = "Microservice - Customer",
                version = "1.0",
                license = @License(
                        name = "AdanD",
                        url = "https://adan-duque.com"
                ),
                termsOfService = "User this project to learn about Microservices"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8097"
                ),
                @Server(
                        description = "Prod ENV",
                        url = "http://anyProdEnv:8097"
                ),
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER

)
public class OpenApiConfig {


}