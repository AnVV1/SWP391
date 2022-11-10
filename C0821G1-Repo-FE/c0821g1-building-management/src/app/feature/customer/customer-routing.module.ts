import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from '../employee/employee-list/employee-list.component';
import {AuthGuard} from '../../helpers/auth.guard';
import {CustomerListComponent} from './customer-list/customer-list.component';


const routes: Routes = [
  {
    path: 'list',
    component: CustomerListComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
