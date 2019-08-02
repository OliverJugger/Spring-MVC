import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-correction-ajouter',
  templateUrl: './correction-ajouter.component.html',
  styleUrls: ['./correction-ajouter.component.css']
})
export class CorrectionAjouterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  ajouterUneCorrection() {
    console.log("ajout");
  }

}
