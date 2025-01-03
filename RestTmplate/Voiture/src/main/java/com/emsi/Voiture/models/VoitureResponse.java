package com.emsi.Voiture.models;

import com.emsi.Voiture.entities.Client;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jdk.jfr.DataAmount;
import lombok.Builder;

@Builder
public class VoitureResponse {
    private Long id;
    private String matricule;
    private String marque;
    private String model;
    private Client client;

    public VoitureResponse() {
    }

    public VoitureResponse(Long id, String matricule, String marque, String model, Client client) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
