package com.example.demothymeleaf.model;

public class Category {
    private String name;
    private String slug;
    public Category() {
    }
    public Category(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
}
