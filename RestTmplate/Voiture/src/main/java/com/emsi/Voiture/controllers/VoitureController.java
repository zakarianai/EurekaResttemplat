package com.emsi.Voiture.controllers;

import com.emsi.Voiture.entities.Voiture;
import com.emsi.Voiture.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser les requêtes depuis Angular
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

//    @Autowired
//    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            //List<Voiture> voitures = voitureRepository.findAll();
            List<Voiture> voitures = voitureService.getAllVoituresAvecClients();
            return ResponseEntity.ok(voitures);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching voitures: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
//            Voiture voiture = voitureRepository.findById(id)
//                    .orElseThrow(() -> new Exception("Voiture Introuvable"));
            Voiture voiture = voitureService.getVoitureAvecClient(id);
             // Fetch the client details using the clientService
            //voiture.setClient(clientService.clientById(voiture.getId_client()));

            return ResponseEntity.ok(voiture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error");
        }
    }
    @PostMapping
    public void saveVoiture(@RequestBody Voiture voiture){
        voitureService.addVoiture(voiture);
    }

//    @GetMapping("/voitures/client/{id}")
//    public ResponseEntity<List<Voiture>> findByClient(@PathVariable Long id) {
//        try {
//            Client client = clientService.clientById(id);
//            if (client != null) {
//                List<Voiture> voitures = voitureRepository.findByIdClient(id);
//                return ResponseEntity.ok(voitures);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @PostMapping("/{clientId}")
//    public ResponseEntity<Object> save(@PathVariable Long clientId, @RequestBody Voiture voiture) {
//        try {
//            // Fetch the client details using the clientService
////            Client client = clientService.clientById(clientId);
//
//
//            if (client != null) {
//                voiture.setId_client(clientId);
//                voiture.setClient(client);
//                Voiture savedVoiture = voitureRepository.save(voiture);
//
//                return ResponseEntity.ok(savedVoiture);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Client not found with ID: " + clientId);
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving voiture: " + e.getMessage());
//        }
//    }

 //   @PutMapping("/{id}")
//    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
//        try {
//            Voiture existingVoiture = voitureRepository.findById(id)
//                    .orElseThrow(() -> new Exception("Voiture not found with ID: " + id));
//
//            // Update only the non-null fields from the request body
//            if (updatedVoiture.getMatricule() != null && !updatedVoiture.getMatricule().isEmpty()) {
//                existingVoiture.setMatricule(updatedVoiture.getMatricule());
//            }
//
//            if (updatedVoiture.getMarque() != null && !updatedVoiture.getMarque().isEmpty()) {
//                existingVoiture.setMarque(updatedVoiture.getMarque());
//            }
//
//            if (updatedVoiture.getModel() != null && !updatedVoiture.getModel().isEmpty()) {
//                existingVoiture.setModel(updatedVoiture.getModel());
//            }
//
//            // Save the updated Voiture
//            Voiture savedVoiture = voitureRepository.save(existingVoiture);
//
//            return ResponseEntity.ok(savedVoiture);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating voiture " + e.getMessage());
//        }
//    }
}
