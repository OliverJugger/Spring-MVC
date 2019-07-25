import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VersionListComponent} from "./version-list/version-list.component";

const routes: Routes = [
  {
    path:'',
    component: VersionListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VersionRoutingModule { }
