package com.emsi.Voiture.repositories;

import com.emsi.Voiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
//    List<Voiture> findByIdClient(Long idClient);
}
