package com.example.demothymeleaf.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
public class Category {
    private String name;
    private String slug;

    public void aa() {
        Category category = new Category("", "");
    }

}
