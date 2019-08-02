import {Component, OnInit, ViewChild} from '@angular/core';
import { MatSort, MatTableModule, MatTableDataSource, MatPaginator } from "@angular/material";
import { Correction } from "../../model/correction";
import { CorrectionService } from "../correction.service";
import { correctionDefault } from 'src/app/model/mocks';


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
 
  displayedColumns: string[] = ['id', 'auteur', 'date', 'titre', 'application', 'etat'];
  correctionDataSource: MatTableDataSource<Correction>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  pageSize;
  pageSizeOptions = [5, 10, 100];

  public corrections: Correction[] = [];
  
  selectedCorrection: Correction;


  constructor(private correctionService : CorrectionService) { }

  ngOnInit() {
    this.correctionService.getListeProgrammes().subscribe(
      result => {
        this.corrections = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.correctionDataSource = new MatTableDataSource(result);
        this.correctionDataSource.paginator = this.paginator;
        this.correctionDataSource.sort = this.sort;
        /*this.correctionDataSource.filterPredicate = (data: Correction, filter: string) =>
            !filter || (data.nom.toLowerCase().includes(filter));*/
      }, error => console.error(error));
  }

  ajouterUneCorrection() {    
    this.selectedCorrection = correctionDefault;
  }  
}
