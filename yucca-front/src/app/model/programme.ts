export class Programme {
  dateCreation: number;
  dateModification: number;
  id: number;
  idProgramme: number;
  nom: string;
  commentaire: string;
  temporaire: string;
  idRepertoire: number;
  idDomaine: number;
  idSousDomaine: number;
  utilisateurCreation: string;
  utilisateurModification: string;

  constructor(public dateCreationVal?: number, public dateModificationVal?: number, public idVal?: number, public idProgrammeVal?: number, public nomVal?: string, public commentaireVal?: string,
              public temporaireVal?: string, public idDomaineVal? : number, public idRepertoireVal? : number,
              public idSousDomaineVal?: number, public utilisateurCreationVal? : string, public utilisateurModificationVal? : string)
 {
   this.dateCreation = dateCreationVal;
   this.dateModification = dateModificationVal;
   this.id = idVal;
   this.idProgramme = idProgrammeVal;
   this.nom = nomVal;
   this.commentaire = commentaireVal;
   this.temporaire = temporaireVal;
   this.idRepertoire = idRepertoireVal;
   this.idDomaine = idDomaineVal;
   this.idSousDomaine = idSousDomaineVal;
   this.utilisateurCreation = utilisateurCreationVal;
   this.utilisateurModification = utilisateurModificationVal;
  }

}
