package com.demobackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {

    @Value("${frontend.url}")
    private String frontendUrl;
    //Config CORS for cross-origin client
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(frontendUrl).allowedMethods("GET", "POST", "PUT", "PATCH","OPTIONS").allowedHeaders("Content-Type",
                        "X-Requested-With",
                        "X-HTTP-Method-Override",
                        "access_token",
                        "Accept").allowCredentials(true);
            }
        };
    }
}
