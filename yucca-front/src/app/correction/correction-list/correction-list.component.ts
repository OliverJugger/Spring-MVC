import {Component, OnInit, ViewChild} from '@angular/core';
import { MatSort, MatTableModule, MatTableDataSource, MatPaginator, Sort } from "@angular/material";
import { Correction } from "../../model/correction";
import { CorrectionService } from "../correction.service";
import { correctionDefault } from 'src/app/model/mocks';
import { CorrectionFormComponent } from '../correction-form/correction-form.component';

const ELEMENT_DATA = [
  {
    orderDate: new Date(),
    orderNumber: 101,
    total: 39.99,
    description: '5lbs of tuna',
    isChecked: false
  },
  {
    orderDate: new Date(),
    orderNumber: 102,
    total: 29.99,
    description: '2lbs of tuna',
    isChecked: false
  }

];

@Component({
  selector: 'app-correction-list',
  templateUrl: './correction-list.component.html',
  styleUrls: ['./correction-list.component.css']
})
export class CorrectionListComponent implements OnInit {
 
  displayedColumns: string[] = ['id', 'auteur', 'date', 'titre', 'domaine', 'etat'];
  correctionDataSource: MatTableDataSource<Correction>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  pageSize;
  pageSizeOptions = [5, 10, 100];

  public corrections: Correction[] = [];  
  selectedCorrection: Correction;

  spinner = 'ok';

  constructor(private correctionService : CorrectionService) { }

  ngOnInit() {
    this.correctionService.getListeCorrections().subscribe(
      result => {
        this.spinner = undefined;
        this.corrections = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.correctionDataSource = new MatTableDataSource(result);
        this.correctionDataSource.paginator = this.paginator;
        this.correctionDataSource.sort = this.sort;
        this.correctionDataSource.filterPredicate = (data: Correction, filter: string) =>
          !filter || (data.id.toString().includes(filter))
          || (data.auteur.nom.toLowerCase().includes(filter))
          || (data.auteur.alias.toLowerCase().includes(filter))
          || (data.domaine.libelleCourt.toLowerCase().includes(filter));                    
      }, error => console.error(error));
    
  }

  applyFilter(filterValue: string) {
    this.correctionDataSource.filter = filterValue.trim().toLowerCase();
    if (this.correctionDataSource.paginator) {
      this.correctionDataSource.paginator.firstPage();
    }
  }

  ajouterUneCorrection() {    
    this.selectedCorrection = correctionDefault;
    this.correctionService.updateCorrection(correctionDefault)
    this.correctionService.updateOpenCorr(true);          
  }
  
  onSelect(correction: Correction) {
    this.selectedCorrection = correction;   
    this.correctionService.updateCorrection(correction)
    this.correctionService.updateOpenCorr(true);     
  }

  sortData(sort: Sort) {
    const data = this.corrections.slice();
    if (!sort.active || sort.direction === '') {
      this.corrections = data;
      return;
    }

    this.correctionDataSource.data = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'idSort': return compare(a.id, b.id, isAsc);
        case 'auteurSort': return compare(a.auteur.alias, b.auteur.alias, isAsc);
        case 'domaineSort': return compare(a.domaine.libelleCourt, b.domaine.libelleCourt, isAsc);
        case 'repertoireSort': return compare(a.titre, b.titre, isAsc);        
        default: return 0;
      }
    });

    function compare(a: number | string, b: number | string, isAsc: boolean) {
      return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
    }
  }
  
  setDefaultCorrection(){
    this.selectedCorrection = null;
    this.correctionService.updateCorrection(correctionDefault)
    this.correctionService.updateOpenCorr(false);
  }

  onUpdate(event) {
    this.selectedCorrection = null;
    this.initMatTable();
  }

  initMatTable() {
    this.correctionService.getListeCorrections().subscribe(
      result => {
        this.corrections = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.correctionDataSource = new MatTableDataSource(result);
        this.correctionDataSource.paginator = this.paginator;
        this.correctionDataSource.sort = this.sort;
        this.correctionDataSource.filterPredicate = (data: Correction, filter: string) =>
          !filter || (data.id.toString().includes(filter))
          || (data.auteur.nom.toLowerCase().includes(filter))
          || (data.auteur.alias.toLowerCase().includes(filter))
          || (data.domaine.libelleCourt.toLowerCase().includes(filter));                    
      }, error => console.error(error));
  }
}
