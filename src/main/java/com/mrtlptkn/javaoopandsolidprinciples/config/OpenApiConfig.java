package com.mrtlptkn.javaoopandsolidprinciples.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenApi() {
        Server server = new Server()
                .url("http://localhost:" + serverPort)
                .description("Development Server");

        return new OpenAPI()
                .servers(List.of(server))
                .info(new Info()
                        .title("Java OOP and SOLID Principles API")
                        .version("1.0.0")
                        .description("Investment Management System API - Java OOP and SOLID Principles Demonstration")
                        .contact(new Contact()
                                .name("API Support")
                                .email("support@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

