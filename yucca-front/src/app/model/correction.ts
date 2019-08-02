export class Correction {
  id: number;
  probleme: string;
  solution: string;
  etat: string;

  constructor(public idVal?: number, public problemeVal?: string, public solutionVal?: string, public etatVal?: string)
 {
    this.id = idVal;
    this.probleme = problemeVal;
    this.solution = solutionVal;
    this.etat = etatVal;
  }

}
