package com.example.xml.libs.jaxb;

import com.example.xml.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.glassfish.jaxb.core.marshaller.CharacterEscapeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Writer;

@Configuration
public class MarshallerHelper {
    @Bean
    public Marshaller personMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);

        // Create the marshaller
        Marshaller marshaller = context.createMarshaller();

        // Set custom character escape handler
        marshaller.setProperty("org.glassfish.jaxb.characterEscapeHandler", (CharacterEscapeHandler) (char[] chars, int start, int len, boolean b, Writer writer) -> {
            writer.write(chars, start, len);
        });
        System.out.println("personMarshaller Bean generated!");

        return marshaller;
    }
}
