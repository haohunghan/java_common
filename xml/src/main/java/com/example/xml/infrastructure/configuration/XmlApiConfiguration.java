package com.example.xml.infrastructure.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="xml-api")
@Getter
@Setter
public class XmlApiConfiguration {
    private String host;
    private String path;
}
