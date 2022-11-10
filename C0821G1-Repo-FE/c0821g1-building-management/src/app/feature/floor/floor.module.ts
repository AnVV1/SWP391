import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FloorRoutingModule } from './floor-routing.module';
import { FloorsListComponent } from './floors-list/floors-list.component';
import { FloorsDeleteComponent } from './floors-delete/floors-delete.component';
import { FloorsEditComponent } from './floors-edit/floors-edit.component';
@NgModule({
  declarations: [FloorsListComponent, FloorsDeleteComponent, FloorsEditComponent],
  exports: [
    FloorsListComponent
  ],
  imports: [
    CommonModule,
    FloorRoutingModule,

  ]
})
export class FloorModule { }
