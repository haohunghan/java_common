package com.example.xml.controller;

import com.example.xml.model.Person;
import jakarta.xml.bind.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.util.Objects;

@RestController
public class PostXMLController {
    Unmarshaller unmarshallerPerson;

    public PostXMLController(Unmarshaller unmarshallerPerson) {
        this.unmarshallerPerson = unmarshallerPerson;
    }
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_XML_VALUE)
    public String get() throws JAXBException {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<String> response = restTemplate
                .exchange("http://localhost:8080/get", HttpMethod.GET, null, String.class);

        String xmlResponse = Objects.requireNonNull(response.getBody());
        StringReader stringReader = new StringReader(xmlResponse);
        Person person = (Person) unmarshallerPerson.unmarshal(stringReader);

        return person.toString();
    }
}
