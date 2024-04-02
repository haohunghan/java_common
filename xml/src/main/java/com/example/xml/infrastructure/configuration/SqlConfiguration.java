package com.example.xml.infrastructure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sql")
@Data
public class SqlConfiguration {
    private String host;
    private String id;
    private String password;
}
