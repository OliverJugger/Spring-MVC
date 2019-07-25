import { Component, OnInit } from '@angular/core';
import {Form, FormControl, Validators} from '@angular/forms';
import { RepertoireService } from '../../repertoire/repertoire.service';
import { DomaineService} from '../../domaine/domaine.service';
import { SousDomaineService} from '../../sous-domaine/sous-domaine.service';
import {Repertoire} from '../../model/repertoire';
import {Domaine} from '../../model/domaine';
import {SousDomaine} from '../../model/sousDomaine';
import {ProgrammeService} from "../programme.service";

@Component({
  selector: 'app-programme-ajouter',
  templateUrl: './programme-ajouter.component.html',
  styleUrls: ['./programme-ajouter.component.css']
})
export class ProgrammeAjouterComponent implements OnInit {
  repertoireSelected: Repertoire;
  domaineSelected: Domaine;
  sousDomaineSelected: SousDomaine;
  temporaireFormControl: FormControl;
  commentaireFormControl: FormControl;
  nomProgramme = '';
  labelPosition = 'before';

  nomFormControl: FormControl;

  public repertoires: Repertoire[] = [];
  public domaines: Domaine[] = [];
  public sousDomaines: SousDomaine[] = [];

  constructor(private repertoireService: RepertoireService,
              private domaineService: DomaineService,
              private sousDomaineService: SousDomaineService,
              private programmeService: ProgrammeService) {}

  ngOnInit() {
    this.nomFormControl = new FormControl('', [
      Validators.required,
      Validators.maxLength(15)
    ]);
    this.temporaireFormControl = new FormControl(false);
    this.commentaireFormControl = new FormControl('', [
      Validators.maxLength(1000)
    ]);

    this.repertoireService.getListeRepertoiresVisibles().subscribe(
      result => {
        this.repertoires = result;
        this.repertoireSelected = result.filter(rep => rep.chemin === 'paye/4gl')[0];
      }, error => console.error(error));

    this.domaineService.getListeDomainesVisibles().subscribe(
      result => {
        this.domaines = result;
        this.domaineSelected = result.filter(dom => dom.libelleLong === 'Application Paye                                            ')[0];
      }, error => console.error(error));

    this.sousDomaineService.getListeSousDomainesVisibles().subscribe(
      result => {
        this.sousDomaines = result;
        this.sousDomaineSelected = result.filter(sousdom => sousdom.libelleLong === 'Remuneration principale')[0];
      }, error => console.error(error));

  }

  onSubmit(){
    /*Programme programme = new Programme();
    this.programmeService.addProgramme();*/
  }

}
