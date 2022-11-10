import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HeaderComponent} from './shared/header/header.component';
import {BodyComponent} from './shared/body/body.component';
import {FloorsDeleteComponent} from './feature/floor/floors-delete/floors-delete.component';
import {AuthGuard} from './helpers/auth.guard';


const routes: Routes = [
  {
    path: 'security',
    loadChildren: () => import('./feature/security/security.module').then(module => module.SecurityModule)
  },
  // {
  //   path: 'home',
  //   component: HeaderComponent
  // },
  {
    path: 'employee',
    loadChildren: () => import('./feature/employee/employee.module').then(module => module.EmployeeModule)
  },
  {
    path: 'customer',
    loadChildren: () => import('./feature/customer/customer.module').then(module => module.CustomerModule)
  },
  {
    path: 'contract', loadChildren: () =>
      import('./feature/contract/contract.module').then(module => module.ContractModule)
  }
  ,
  {
    path: 'floors',
    loadChildren: () => import('./feature/floor/floor.module').then(module => module.FloorModule)
  },
  {
    path: 'spaces',
    loadChildren: () => import('./feature/space/space.module').then(module => module.SpaceModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
