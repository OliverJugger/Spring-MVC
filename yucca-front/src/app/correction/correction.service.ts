import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Correction } from '../model/correction';
import { Ressources } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class CorrectionService {

  constructor(private http: HttpClient,
    private ressources: Ressources) { }

  public getListeProgrammes() {
    return this.http.get<Correction[]>(this.ressources.server + 'correction');
  }
}
