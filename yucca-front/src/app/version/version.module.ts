import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VersionRoutingModule } from './version-routing.module';
import { VersionListComponent } from './version-list/version-list.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';


// Material
import {MatButtonModule, MatSnackBarModule, MatTabsModule} from '@angular/material';
import {MatTableModule} from '@angular/material';
import {MatSortModule} from '@angular/material';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatPaginatorIntl} from '@angular/material';
import {getFrenchPaginatorIntl} from '../traduction/french-paginator-intl';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material';
import { MatCardModule} from '@angular/material';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material';
import {MatCheckboxModule} from '@angular/material/checkbox';

@NgModule({
  declarations: [VersionListComponent],
  imports: [
    CommonModule,
    VersionRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    // Material
    MatTabsModule,
    MatSortModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    MatCheckboxModule,
    MatButtonModule,
    MatSnackBarModule
  ],
  providers: [
    { provide : MatPaginatorIntl, useValue: getFrenchPaginatorIntl()}
  ]
})
export class VersionModule { }
