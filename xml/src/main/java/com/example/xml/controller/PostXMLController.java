package com.example.xml.controller;

import com.example.xml.model.Person;
import com.example.xml.service.IPostXmlService;
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
    private final IPostXmlService postXmlService;

    public PostXMLController(IPostXmlService postXmlService) {
        this.postXmlService = postXmlService;
    }

    @PostMapping(value = "/post", produces = MediaType.APPLICATION_XML_VALUE)
    public String post() throws JAXBException {
        return postXmlService.postXml();
    }
}
