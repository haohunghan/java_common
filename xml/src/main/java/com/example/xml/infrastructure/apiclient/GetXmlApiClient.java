package com.example.xml.infrastructure.apiclient;

import com.example.xml.infrastructure.configuration.XmlApiConfiguration;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetXmlApiClient extends AbstractApiClient implements IGetXmlApiClient {
    private RestTemplate restTemplate;

    private final XmlApiConfiguration xmlApiConfiguration;

    public GetXmlApiClient(RestTemplateBuilder restTemplateBuilder, XmlApiConfiguration xmlApiConfiguration) {
        super(restTemplateBuilder);
        this.xmlApiConfiguration = xmlApiConfiguration;
    }

    @PostConstruct
    public void init() {
        this.restTemplate = super.createRestTemplate();
    }

    public String getXml() {
        final String url = xmlApiConfiguration.getHost() + xmlApiConfiguration.getPath();

        final ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, null, String.class);

        return response.getBody();
    }
}
