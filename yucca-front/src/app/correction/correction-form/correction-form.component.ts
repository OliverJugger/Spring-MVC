import { Component, OnInit, Input } from '@angular/core';
import { Correction } from 'src/app/model/correction';

@Component({
  selector: 'app-correction-form',
  templateUrl: './correction-form.component.html',
  styleUrls: ['./correction-form.component.css']
})
export class CorrectionFormComponent implements OnInit {
 
  @Input() correctionInput: Correction;

  auteurs: String[] = [
    "Julien",
    "Anthony",
    "Alexandre"
  ];

  constructor() { }

  ngOnInit() {
  }

  ajouterLienProbleme() {
    console.log("ajout Lien problem");
  }

}
