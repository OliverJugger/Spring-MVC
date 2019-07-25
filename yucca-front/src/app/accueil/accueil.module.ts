import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccueilComponent } from './accueil/accueil.component';
import { ChartsModule } from 'ng2-charts';
import { PieChartComponent } from '../charts/pie-chart/pie-chart.component';
import { BarChartComponent } from '../charts/bar-chart/bar-chart.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {LineChartComponent} from '../charts/line-chart/line-chart.component';
import {AccueilRoutingModule} from './accueil-routing.module';

@NgModule({
  declarations: [
    AccueilComponent,
    LineChartComponent,
    PieChartComponent,
    BarChartComponent
  ],
  imports: [
    CommonModule,
    AccueilRoutingModule,
    MatGridListModule,

    // NG CHARTS
    ChartsModule
  ]
})
export class AccueilModule { }
