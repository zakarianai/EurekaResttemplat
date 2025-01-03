import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import axios from 'axios';

@Component({
  selector: 'app-voiture',
  standalone: false,
  
  templateUrl: './voiture.component.html',
  styleUrl: './voiture.component.css'
})
export class VoitureComponent implements OnInit {
  isSubmitting: boolean = false;
  cars: any[] = [];
  newCar = { matricule: '', marque: '', model: '', id_client: null };

  private apiUrl = 'http://localhost:8888/SERVICE-VOITURE/api/car';

  constructor() {}

  ngOnInit(): void {
    this.getAllCars();
  }

  // Récupérer toutes les voitures
  getAllCars() {
    axios.get(this.apiUrl)
      .then(response => {
        this.cars = response.data;
      })
      .catch(error => {
        console.error('Erreur lors de la récupération des voitures', error);
      });
  }

  // Ajouter une voiture
  addCar() {
    if (!this.newCar.matricule || !this.newCar.marque || !this.newCar.model || !this.newCar.id_client) {
      console.error('Veuillez remplir tous les champs');
      return;
    }

    this.isSubmitting = true;  // Indiquer qu'une requête est en cours
    axios.post(this.apiUrl, this.newCar, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(() => {
        console.log('Voiture ajoutée avec succès');
        this.getAllCars();  // Actualiser la liste des voitures après ajout
        this.newCar = { matricule: '', marque: '', model: '', id_client: null };  // Réinitialiser les champs
      })
      .catch(error => {
        console.error('Erreur lors de l\'ajout de la voiture', error);
      })
      .finally(() => {
        this.isSubmitting = false;  // Réinitialiser l'indicateur de requête
      });
  }
  
}
