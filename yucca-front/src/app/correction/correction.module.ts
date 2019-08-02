import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CorrectionRoutingModule } from './correction-routing.module';
import { CorrectionListComponent } from './correction-list/correction-list.component';
import { MatSortModule} from "@angular/material";
import { MatTableModule } from "@angular/material";
import { CorrectionAjouterComponent } from './correction-ajouter/correction-ajouter.component';
import { CorrectionFormComponent } from './correction-form/correction-form.component';

import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import { MatCardModule} from '@angular/material';
import {MatInputModule} from '@angular/material';

@NgModule({
  declarations: [CorrectionListComponent, CorrectionAjouterComponent, CorrectionFormComponent],
  imports: [
    CommonModule,
    CorrectionRoutingModule,
  //Material
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatCardModule,
    MatInputModule
  ]
})
export class CorrectionModule { }
