package com.codingbox.monster;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:applicationAPI.yml")
@Getter
public class ApiConfig {
    @Value("${rapid.api.key}")
    private String apiKey;
    @Value("${rapid.api.requestURI}")
    private String apirequestURI;
    @Value("${rapid.api.host}")
    private String apihost;
}
