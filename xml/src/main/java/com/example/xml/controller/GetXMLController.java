package com.example.xml.controller;

import com.example.xml.service.IGetXmlService;
import jakarta.xml.bind.JAXBException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;

@RestController
@RequestMapping("/get")
public class GetXMLController {
    private final IGetXmlService getXmlService;

    public GetXMLController(IGetXmlService getXmlService) {
        this.getXmlService = getXmlService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXML() throws JAXBException {
        return getXmlService.getPersonXml();
    }
}
