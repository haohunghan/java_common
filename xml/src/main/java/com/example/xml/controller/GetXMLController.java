package com.example.xml.controller;

import com.example.xml.model.Person;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;

@RestController
@RequestMapping("/get")
public class GetXMLController {
    private final Marshaller personMarshaller;

    public GetXMLController(Marshaller personMarshaller) {
        this.personMarshaller = personMarshaller;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXML() throws JAXBException {
        Person person = Person.of("Nguyen Anh Hao <></ Phong, Quan &7", 27, "Ton Duc Thang University", "Tan<></ Phong, Quan &7, HCM");

        StringWriter stringWriter = new StringWriter();

        personMarshaller.marshal(person, stringWriter);
        return stringWriter.toString();
    }
}
