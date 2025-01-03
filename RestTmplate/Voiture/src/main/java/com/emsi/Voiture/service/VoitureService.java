package com.emsi.Voiture.service;

import com.emsi.Voiture.entities.Client;
import com.emsi.Voiture.entities.Voiture;
import com.emsi.Voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private RestTemplate restTemplate; // Permet d'appeler le service externe

    private static final String CLIENT_SERVICE_URL = "http://localhost:8888/SERVICE-CLIENT/api/client/";

    public Voiture getVoitureAvecClient(Long voitureId) {
        Voiture voiture = voitureRepository.findById(voitureId)
                .orElseThrow(() -> new RuntimeException("Voiture introuvable"));

        if (voiture.getId_client() != null) {
            // Appel au service Client pour récupérer l'objet client
            Client client = restTemplate.getForObject(CLIENT_SERVICE_URL + voiture.getId_client(), Client.class);
            voiture.setClient(client);
        }

        return voiture;
    }
    public List<Voiture> getAllVoituresAvecClients() {
        List<Voiture> voitures = voitureRepository.findAll();

        // Pour chaque voiture, récupérer les données du client si `id_client` est défini
        voitures.forEach(voiture -> {
            if (voiture.getId_client() != null) {
                Client client = restTemplate.getForObject(CLIENT_SERVICE_URL + voiture.getId_client(), Client.class);
                voiture.setClient(client);
            }
        });
        return voitures;
    }
    public void addVoiture(Voiture voiture) {
        // Vérifier si le client existe dans le service Client avant d'ajouter la voiture
        if (voiture.getId_client() != null) {
            Client client = restTemplate.getForObject(CLIENT_SERVICE_URL + voiture.getId_client(), Client.class);
            if (client == null) {
                throw new RuntimeException("Client introuvable pour l'id " + voiture.getId_client());
            }
        }

        // Sauvegarder la voiture dans la base de données
         voitureRepository.save(voiture);
    }
}
