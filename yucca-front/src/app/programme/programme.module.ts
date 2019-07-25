import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ProgrammeRoutingModule } from './programme-routing.module';
import { ProgrammeListComponent } from './programme-list/programme-list.component';
import { ProgrammeAjouterComponent } from './programme-ajouter/programme-ajouter.component';

// Material
import {MatButtonModule, MatTabsModule} from '@angular/material';
import {MatTableModule} from '@angular/material';
import {MatSortModule} from '@angular/material';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatPaginatorIntl} from '@angular/material';
import {getFrenchPaginatorIntl} from '../traduction/french-paginator-intl';
import { ProgrammeRechercheGlobaleComponent } from './programme-recherche-globale/programme-recherche-globale.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material';
import { MatCardModule} from '@angular/material';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material';
import {MatCheckboxModule} from '@angular/material/checkbox';

@NgModule({
  declarations: [ProgrammeListComponent, ProgrammeRechercheGlobaleComponent, ProgrammeAjouterComponent],
    imports: [
        CommonModule,
        ProgrammeRoutingModule,
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
        MatButtonModule
    ],
  providers: [
    { provide : MatPaginatorIntl, useValue: getFrenchPaginatorIntl()}
  ]
})
export class ProgrammeModule { }
