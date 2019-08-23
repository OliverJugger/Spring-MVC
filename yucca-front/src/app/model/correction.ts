import { Domaine } from './domaine';
import { Auteur } from './auteur';

export class Correction {
  id: number;
  auteur : Auteur;
  domaine: Domaine;  
  probleme: string;
  solution: string;
  commentaire : string;
  etat: string;
  titre : string;

  constructor(public idVal?: number, public problemeVal?: string, public solutionVal?: string, public etatVal?: string)
 {
    this.id = idVal;
    this.probleme = problemeVal;
    this.solution = solutionVal;
    this.etat = etatVal;
  }

}
