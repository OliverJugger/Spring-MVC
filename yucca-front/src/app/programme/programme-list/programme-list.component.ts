import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource } from '@angular/material';
import {Programme} from '../../model/programme';
import { ProgrammeService } from '../programme.service';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-programme-list',
  templateUrl: './programme-list.component.html',
  styleUrls: ['./programme-list.component.css']
})
export class ProgrammeListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'nom', 'idDomaine', 'idRepertoire', 'idSousDomaine'];
  programmesDataSource: MatTableDataSource<Programme>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  pageSize;
  pageSizeOptions = [5, 10, 100];

  public programmes: Programme[] = [];

  constructor(private programmeService: ProgrammeService) {}


  ngOnInit() {
    this.programmeService.getListeProgrammes().subscribe(
      result => {
        this.programmes = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.programmesDataSource = new MatTableDataSource(result);
        this.programmesDataSource.paginator = this.paginator;
        this.programmesDataSource.sort = this.sort;
        this.programmesDataSource.filterPredicate = (data: Programme, filter: string) =>
            !filter || (data.nom.toLowerCase().includes(filter));
      }, error => console.error(error));
  }

  applyFilter(filterValue: string) {
    this.programmesDataSource.filter = filterValue.trim().toLowerCase();
    if (this.programmesDataSource.paginator) {
      this.programmesDataSource.paginator.firstPage();
    }
  }

}
