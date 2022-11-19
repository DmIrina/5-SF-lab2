package com.example.lab2.entity;


import lombok.Data;

@Data
public class Movie {
    private int id;
    private String name;
    private String description;

    public Movie(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
