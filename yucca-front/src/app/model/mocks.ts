import {Correction} from './correction';
import {Programme} from './programme';
import {SousDomaine} from "./sousDomaine";
import {Repertoire} from "./repertoire";
import {Domaine} from "./domaine";
import {Version} from './version';

export const CORRECTIONS1: Correction[] = [
  {id: 1, probleme: 'Probleme 1.1', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 2, probleme: 'Probleme 1.2', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 3, probleme: 'Probleme 1.3', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 4, probleme: 'Probleme 1.4', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 5, probleme: 'Probleme 1.5', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 6, probleme: 'Probleme 1.6', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 7, probleme: 'Probleme 1.7', solution: 'Solution 1.1', etat: 'Ouvert'}
];

export const CORRECTIONS2: Correction[] = [
  {id: 1, probleme: 'Probleme 2.1', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 2, probleme: 'Probleme 2.2', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 3, probleme: 'Probleme 2.3', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 4, probleme: 'Probleme 2.4', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 5, probleme: 'Probleme 2.5', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 6, probleme: 'Probleme 2.6', solution: 'Solution 1.1', etat: 'Ouvert'},
  {id: 7, probleme: 'Probleme 2.7', solution: 'Solution 1.1', etat: 'Ouvert'}
];

export const repertoireDefault: Repertoire = {
  id: 14,
  chemin: 'paye/4gl',
  raccourciUnix: '$P4GL     ',
  visible: '1',
};

export const sousDomaineDefault: SousDomaine = {
    id: 1,
    libelleCourt: 'REM',
    libelleLong: 'Remuneration principale',
    visible: '1'
};

export const domaineDefault: Domaine = {
  id: 1,
  libelleCourt: 'PAYE      ',
  libelleLong: 'Application Paye                                            ',
  visible: '1'
};

export const programmeDefault: Programme = {
  dateCreation: null,
  dateModification: null,
  id: null,
  idProgramme: null,
  nom: '',
  commentaire: '',
  temporaire: 'N',
  domaine: domaineDefault,
  repertoire: repertoireDefault,
  sousDomaine: sousDomaineDefault,
  utilisateurCreation: 'YUCCA-FRONT',
  utilisateurModification: 'YUCCA-FRONT'
};

export const correctionDefault: Correction = {
  id : null,
  probleme : 'problemeDefault',
  solution : 'solutionDefault',
  etat : 'etatDefault'
};

export const versionDefault: Version = {
  id: null,
  libelle: '',
  etat: 'A',
  utilisateurCreation: 'YUCCA-FRONT',
  utilisateurModification: 'YUCCA-FRONT',
  dateCreation: null,
  dateModification: null
};
