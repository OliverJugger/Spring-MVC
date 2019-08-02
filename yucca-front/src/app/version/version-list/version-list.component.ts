import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSnackBar, MatSnackBarConfig, MatSort, MatTableDataSource, Sort} from '@angular/material';
import {Version} from '../../model/version';
import {VersionService} from '../../version/version.service';
import {versionDefault} from '../../model/mocks';

@Component({
  selector: 'app-version-list',
  templateUrl: './version-list.component.html',
  styleUrls: ['./version-list.component.css']
})
export class VersionListComponent implements OnInit {
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  displayedColumns: string[] = ['id', 'libelle', 'etat'];
  versionsDataSource: MatTableDataSource<Version>;
  pageSize;
  pageSizeOptions = [5, 10, 100];

  public versions: Version[] = [];
  selectedVersion: Version;

  constructor(private versionService: VersionService, public snackBar: MatSnackBar) {}

  ngOnInit() {
    this.initMatTable();
  }

  applyFilter(filterValue: string) {
    this.versionsDataSource.filter = filterValue.trim().toLowerCase();
    if (this.versionsDataSource.paginator) {
      this.versionsDataSource.paginator.firstPage();
    }
  }

  onSelect(version: Version) {
    this.selectedVersion = version;
  }

  ajouterVersion() {
    this.selectedVersion = versionDefault;
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

  initMatTable() {
    this.versionService.getListeVersions().subscribe(
      result => {
        this.versions = result;
        this.pageSize = result.length > 100 ? 10 : 5;
        this.versionsDataSource = new MatTableDataSource(result);
        this.versionsDataSource.paginator = this.paginator;
        this.versionsDataSource.sort = this.sort;
        this.versionsDataSource.filterPredicate = (data: Version, filter: string) =>
          !filter || (data.id.toString().includes(filter))
          || (data.libelle.toLowerCase().includes(filter))
          || (data.etat.toLowerCase().includes(filter));
      }, error => {
        console.error(error);
        this.error();
      });
  }

  sortData(sort: Sort) {
    const data = this.versions.slice();
    if (!sort.active || sort.direction === '') {
      this.versions = data;
      return;
    }

    this.versionsDataSource.data = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'idSort': return compare(a.id, b.id, isAsc);
        case 'nomSort': return compare(a.libelle, b.libelle, isAsc);
        case 'domaineSort': return compare(a.etat, b.etat, isAsc);
        default: return 0;
      }
    });

    function compare(a: number | string, b: number | string, isAsc: boolean) {
      return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
    }
  }

  pagination(event) {
    console.log(event);
  }

}
