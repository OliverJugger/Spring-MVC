import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CorrectionRoutingModule } from './correction-routing.module';
import { CorrectionListComponent } from './correction-list/correction-list.component';
import { MatSortModule} from "@angular/material";
import { MatTableModule } from "@angular/material";

@NgModule({
  declarations: [CorrectionListComponent],
  imports: [
    CommonModule,
    CorrectionRoutingModule,
  //Material
    MatSortModule,
    MatTableModule
  ]
})
export class CorrectionModule { }
