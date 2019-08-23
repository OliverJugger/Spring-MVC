import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Correction } from 'src/app/model/correction';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { DomaineService } from 'src/app/domaine/domaine.service';
import { Domaine } from 'src/app/model/domaine';
import { AuteurService } from 'src/app/auteur/auteur.service';
import { Auteur } from 'src/app/model/auteur';
import { CorrectionService } from '../correction.service';
import { correctionDefault } from 'src/app/model/mocks';
import { ThemeService } from 'ng2-charts';

@Component({
  selector: 'app-correction-form',
  templateUrl: './correction-form.component.html',
  styleUrls: ['./correction-form.component.css']
})
export class CorrectionFormComponent implements OnInit {
  
  @Output() updateView = new EventEmitter();
  
  public domaines: Domaine[] = [];
  public auteurs: Auteur[] = [];

  //Default correction
  public correctionInput : Correction = correctionDefault
  public correctionIsOpen : Boolean = false

  constructor(private domaineService: DomaineService, private auteurService: AuteurService, private correctionService : CorrectionService) {
    this.domaineService.getListeDomainesVisibles().subscribe(
      result => {
        this.domaines = result;
      }, error => console.error(error));

    this.auteurService.getListeAuteursActifs().subscribe(
      result => {
        this.auteurs = result;
      }, error => console.error(error));
  }

  ngOnInit() {
      this.correctionService.correctionObs.subscribe(data => 
        this.correctionInput = data
      )
      this.correctionService.openCorrObs.subscribe(data =>
        this.correctionIsOpen = data
      )
      
      console.log(this.correctionInput)
  }

  ajouterLienProbleme() {
    console.log("ajout Lien problem");
  }

  ajouterUneCorrection() {
    
    console.log(this.correctionInput) 
    
    this.correctionService.addCorrection(this.correctionInput).subscribe(
      created => {
        console.log("Correction ajouté" + created)
        this.correctionService.updateOpenCorr(false);
        this.updateView.emit('success');
      },
      error => {
        console.log("Erreur : " + error)
      }
    )

    
  }

  @Output() evenement = new EventEmitter();
  annulerAjout(){
    this.evenement.emit();
  }

  onSubmit() {
    
  }

  compareObjectsAuteur(o1: any, o2: any): boolean {
    if (o1 == undefined || o2 == undefined)
      return false
    return o1.alias === o2.alias;
  }

  compareObjectsDomain(o1: any, o2: any): boolean {
    if (o1 == undefined || o2 == undefined)
      return false
    return o1.libelleCourt === o2.libelleCourt;
  } 

}
