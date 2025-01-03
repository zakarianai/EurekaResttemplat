package com.emsi.Voiture.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private Float age;

    public Client() {
    }

    public Client(Long id, String nom, Float age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }
}
