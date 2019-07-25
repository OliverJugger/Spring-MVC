import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CorrectionListComponent} from "./correction-list/correction-list.component";

const routes: Routes = [
  {
    path:'',
    component: CorrectionListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CorrectionRoutingModule { }
