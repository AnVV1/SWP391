import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccessDenyComponent} from './access-deny/access-deny.component';
import {LoginComponent} from './login/login.component';


const routes: Routes = [
  {path: 'access-denied', component: AccessDenyComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule { }
