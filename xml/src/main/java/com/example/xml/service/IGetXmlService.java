package com.example.xml.service;

import jakarta.xml.bind.JAXBException;

public interface IGetXmlService {
    String getPersonXml() throws JAXBException;
}
