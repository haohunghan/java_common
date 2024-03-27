package com.example.xml.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XmlRootElement
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Person {
    @XmlElement
    @XmlJavaTypeAdapter(ConvertCDATA.class)
    private String name;

    @XmlElement
    private int age;

    @XmlElement
    private School school;

    @Builder(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class School {
        @XmlElement
        private String name;

        @XmlElement
        @XmlJavaTypeAdapter(ConvertCDATA.class)
        private String address;
    }

    /**
     *
     * @return
     */
    public static Person of(final String personName, final int personAge, final String schoolName, final String schoolAddress) {
        School school = School.builder()
                .address(schoolAddress)
                .name(schoolName)
                .build();

        return Person.builder()
                .school(school)
                .name(personName)
                .age(personAge)
                .build();
    }

    public static class ConvertCDATA extends XmlAdapter<String, String> {

        @Override
        public String unmarshal(String s) {
            return s;
        }

        @Override
        public String marshal(String s) {
            return "<![CDATA[" + s + "]]>";
        }
    }
}

