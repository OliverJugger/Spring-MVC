export class Version {
  id: number;
  libelle: string;
  etat: string;
  utilisateurCreation: string;
  utilisateurModification: string;
  dateCreation: number;
  dateModification: number;

  constructor(public idVal?: number, public libelleVal?: string,
              public utilisateurCreationVal?: string, public utilisateurModificationVal?: string,
              public dateCreationVal?: number, public dateModificationVal?: number) {
    this.id = idVal;
    this.libelle = libelleVal;
    this.dateCreation = dateCreationVal;
    this.dateModification = dateModificationVal;
    this.utilisateurCreation = utilisateurCreationVal;
    this.utilisateurModification = utilisateurModificationVal;
  }
}
