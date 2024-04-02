package com.example.xml.service.impl;

import com.example.xml.infrastructure.apiclient.GetXmlApiClient;
import com.example.xml.infrastructure.apiclient.IGetXmlApiClient;
import com.example.xml.model.Person;
import com.example.xml.service.IPostXmlService;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.Objects;

@Service
public class PostXmlService implements IPostXmlService {
    private final Unmarshaller unmarshallerPerson;

    private final IGetXmlApiClient getXmlApiClient;

    public PostXmlService(Unmarshaller unmarshallerPerson, IGetXmlApiClient getXmlApiClient) {
        this.unmarshallerPerson = unmarshallerPerson;
        this.getXmlApiClient = getXmlApiClient;
    }

    @Override
    public String postXml() throws JAXBException {
        String stringResponse = getXmlApiClient.getXml();

        String xmlResponse = Objects.requireNonNull(stringResponse);
        StringReader stringReader = new StringReader(xmlResponse);
        Person person = (Person) unmarshallerPerson.unmarshal(stringReader);

        return person.toString();
    }
}
