package com.codingbox.monster;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApiConfig {
    @Value("${rapid.api.key}")
    private String apiKey;
    @Value("${rapid.api.requestURI}")
    private String apirequestURI;
    @Value("${rapid.api.host}")
    private String apihost;
    @Value("${spring.datasource.url}")
    private String databaseurl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver_class_name;
}
