import {Component,  Output, EventEmitter, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource } from '@angular/material';
import {Programme} from '../../model/programme';
import { ProgrammeService } from '../programme.service';
import {MatSort, Sort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';
import {programmeDefault} from '../../model/mocks';

@Component({
  selector: 'app-programme-list',
  templateUrl: './programme-list.component.html',
  styleUrls: ['./programme-list.component.css']
})
export class ProgrammeListComponent implements OnInit {
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  spinner = 'ok';

  displayedColumns: string[] = ['id', 'nom', 'idDomaine', 'idRepertoire', 'idSousDomaine'];
  programmesDataSource: MatTableDataSource<Programme>;
  pageSize;
  pageSizeOptions = [5, 10, 100];

  public programmes: Programme[] = [];
  selectedProgramme: Programme;
  selectedAction: string;

  constructor(private programmeService: ProgrammeService, public snackBar: MatSnackBar) {}

  ngOnInit() {
    this.initMatTable();
  }

  applyFilter(filterValue: string) {
    this.programmesDataSource.filter = filterValue.trim().toLowerCase();
    this.programmes = this.programmesDataSource.data;
    if (this.programmesDataSource.paginator) {
      this.programmesDataSource.paginator.firstPage();
    }
  }

  onSelect(programme: Programme) {
    this.selectedAction = 'Modifier';
    this.selectedProgramme = programme;
  }

  ajouterProgramme() {
    this.selectedAction = 'Ajouter';
    this.selectedProgramme = programmeDefault;
  }

  rechercherProgramme() {
    this.selectedAction = 'Rechercher';
    this.selectedProgramme = programmeDefault;
  }

  error() {
      const config = new MatSnackBarConfig();
      config.verticalPosition = 'top';
      config.horizontalPosition = 'center';
      // config.duration = 5000;
      this.snackBar.open('Une erreur est survenue pendant le chargement des données, veuillez réessayer ultérieurement.'
        , 'Fermer', config);
  }

  onUpdate(event) {
    this.initMatTable();
  }

  onCancel(event) {
    this.selectedProgramme = null;
  }

  initMatTable() {
    this.programmeService.getListeProgrammes().subscribe(
      result => {
        this.spinner = undefined;
        this.programmes = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.programmesDataSource = new MatTableDataSource(result);
        this.programmesDataSource.paginator = this.paginator;
        this.programmesDataSource.sort = this.sort;
        this.programmesDataSource.filterPredicate = (data: Programme, filter: string) =>
          !filter || (data.id.toString().includes(filter))
          || (data.nom.toLowerCase().includes(filter))
          || (data.domaine.libelleLong.toLowerCase().includes(filter))
          || (data.repertoire.chemin.toLowerCase().includes(filter))
          || (data.sousDomaine.libelleLong.toLowerCase().includes(filter));
      }, error => {
        console.error(error);
        this.error();
      });
  }

  sortData(sort: Sort) {
    const data = this.programmes.slice();
    if (!sort.active || sort.direction === '') {
      this.programmes = data;
      return;
    }

    this.programmesDataSource.data = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'idSort': return compare(a.id, b.id, isAsc);
        case 'nomSort': return compare(a.nom, b.nom, isAsc);
        case 'domaineSort': return compare(a.domaine.libelleCourt, b.domaine.libelleCourt, isAsc);
        case 'repertoireSort': return compare(a.repertoire.chemin, b.repertoire.chemin, isAsc);
        case 'sousDomaineSort': return compare(a.sousDomaine.libelleCourt, b.sousDomaine.libelleCourt, isAsc);
        default: return 0;
      }
    });

    function compare(a: number | string, b: number | string, isAsc: boolean) {
      return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
    }
  }
}
