import {Component, OnInit, ViewChild} from '@angular/core';
import { MatSort, MatTableModule, MatTableDataSource } from "@angular/material";


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
  displayColumns : string[] = ['actions', 'orderNumber', 'orderDate', 'description', 'total' ];
  dataSource = new MatTableDataSource(ELEMENT_DATA);


  constructor() { }

  ngOnInit() {

  }

}
