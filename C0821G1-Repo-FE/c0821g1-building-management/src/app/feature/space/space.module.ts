import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SpaceListComponent} from './space-list/space-list.component';
import {SpaceCreateComponent} from './space-create/space-create.component';
import {SpaceEditComponent} from './space-edit/space-edit.component';
import {SpaceDeleteComponent} from './space-delete/space-delete.component';
import {ReactiveFormsModule} from '@angular/forms';
import {NgxSpinnerModule} from 'ngx-bootstrap-spinner';
import {SpaceRoutingModule} from './space-routing.module';
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  declarations: [SpaceListComponent, SpaceCreateComponent, SpaceEditComponent, SpaceDeleteComponent],
  imports: [
    CommonModule,
    SpaceRoutingModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    MatDialogModule
  ]
})
export class SpaceModule {
}
