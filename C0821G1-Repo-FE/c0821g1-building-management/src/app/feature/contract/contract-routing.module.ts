import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ContractListComponent} from './contract-list/contract-list.component';
import {ContractEditComponent} from './contract-edit/contract-edit.component';
import {AuthGuard} from '../../helpers/auth.guard';
import {ContractCreateComponent} from './contract-create/contract-create.component';


const routes: Routes = [
  {
    path: 'list', component: ContractListComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  },
  {
    path: 'edit/:id', component: ContractEditComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  },
  {
    path: 'create', component: ContractCreateComponent, canActivate: [AuthGuard],
    data: {expectedRole: ['ROLE_ADMIN', 'ROLE_EMPLOYEE']}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContractRoutingModule {
}
