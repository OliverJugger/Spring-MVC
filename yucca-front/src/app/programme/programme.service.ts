import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Ressources } from '../app.constants';
import { Programme} from '../model/programme';

@Injectable({
  providedIn: 'root'
})
export class ProgrammeService {

  constructor(private http: HttpClient,
              private ressources: Ressources) { }

  public getListeProgrammes() {
    return this.http.get<Programme[]>(this.ressources.server + 'programme');
  }

  public addProgramme(programme: Programme) {
    console.log(programme);
    const body = JSON.stringify(programme);
    return this.http.post(this.ressources.server + 'programme/', body);
  }

}


