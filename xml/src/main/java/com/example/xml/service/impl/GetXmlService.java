package com.example.xml.service.impl;

import com.example.xml.model.Person;
import com.example.xml.service.IGetXmlService;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
public class GetXmlService implements IGetXmlService {

    private final Marshaller personMarshaller;

    public GetXmlService(Marshaller personMarshaller) {
        this.personMarshaller = personMarshaller;
    }

    @Override
    public String getPersonXml() throws JAXBException {
        Person person = Person.of("Nguyen Anh Hao <></ Phong, Quan &7", 27, "Ton Duc Thang University", "Tan<></ Phong, Quan &7, HCM");

        StringWriter stringWriter = new StringWriter();
        personMarshaller.marshal(person, stringWriter);

        return stringWriter.toString();
    }
}
