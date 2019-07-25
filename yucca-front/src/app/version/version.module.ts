import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VersionRoutingModule } from './version-routing.module';
import { VersionListComponent } from './version-list/version-list.component';

@NgModule({
  declarations: [VersionListComponent],
  imports: [
    CommonModule,
    VersionRoutingModule
  ]
})
export class VersionModule { }
