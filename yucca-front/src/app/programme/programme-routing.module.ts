import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProgrammeListComponent} from './programme-list/programme-list.component';
import { ProgrammeAjouterComponent } from './programme-ajouter/programme-ajouter.component';

const routes: Routes = [
  {
    path: 'list',
    component: ProgrammeListComponent
  },
  {
    path: 'ajouter',
    component: ProgrammeAjouterComponent
  },
  {
    path : '',
    redirectTo: 'list',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProgrammeRoutingModule { }
