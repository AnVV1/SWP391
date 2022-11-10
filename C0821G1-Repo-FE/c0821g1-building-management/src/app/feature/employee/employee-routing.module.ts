import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EmployeeCreateComponent} from './employee-create/employee-create.component';
import {EmployeeEditComponent} from './employee-edit/employee-edit.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';

import {EmployeeDeleteComponent} from './employee-delete/employee-delete.component';
import {EmployeeDetailComponent} from './employee-detail/employee-detail.component';
import {AuthGuard} from '../../helpers/auth.guard';
import {EmployeeEditPasswordComponent} from './employee-edit-password/employee-edit-password.component';


const routes: Routes = [
  {
    path: 'list',
    component: EmployeeListComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  },
  {
    path: 'delete/:id', component: EmployeeDeleteComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN']}
  },
  {
    path: 'detail/:id', component: EmployeeDetailComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  },
  {
    path: 'create', component: EmployeeCreateComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN']}
  },
  {
    path: 'update/:id', component: EmployeeEditComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN']}
  },
  {
    path: 'changePassword/:id', component: EmployeeEditPasswordComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class EmployeeRoutingModule {
}
