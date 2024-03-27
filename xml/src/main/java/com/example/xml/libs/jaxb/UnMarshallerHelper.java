package com.example.xml.libs.jaxb;

import com.example.xml.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnMarshallerHelper {
    @Bean
    public Unmarshaller unmarshallerPerson() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);

        // Create the marshaller
        return context.createUnmarshaller();
    }
}
