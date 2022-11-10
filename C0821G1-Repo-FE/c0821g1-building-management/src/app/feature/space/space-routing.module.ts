import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SpaceCreateComponent} from './space-create/space-create.component';
import {SpaceListComponent} from './space-list/space-list.component';
import {SpaceEditComponent} from './space-edit/space-edit.component';


const routes: Routes = [
  {path: 'create', component: SpaceCreateComponent},
  {path: 'list', component: SpaceListComponent},
  {path: 'edit/:id', component: SpaceEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SpaceRoutingModule { }
