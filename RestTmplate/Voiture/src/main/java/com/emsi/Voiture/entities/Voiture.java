package com.emsi.Voiture.entities;

import jakarta.persistence.*;

@Entity
public class Voiture {
    @Id
    @GeneratedValue
    private Long id;
    private String matricule;
    private String marque;
    private String model;
    private Long id_client;
    @Transient
    @ManyToOne
    private Client client;

    public Voiture() {
    }

    public Voiture(Long id, String matricule, String marque, String model, Long id_client, Client client) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.id_client = id_client;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
