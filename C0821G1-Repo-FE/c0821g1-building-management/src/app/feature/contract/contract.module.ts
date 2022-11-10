import { NgModule } from '@angular/core';
import {CommonModule, DatePipe} from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ContractDeleteComponent } from './contract-delete/contract-delete.component';
import { ContractEditComponent } from './contract-edit/contract-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {MatDialogModule} from '@angular/material/dialog';
import { ContractCreateComponent } from './contract-create/contract-create.component';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../../../environments/environment';
import {NgxSpinnerModule} from 'ngx-bootstrap-spinner';


@NgModule({
  declarations: [ContractListComponent, ContractDeleteComponent, ContractEditComponent, ContractCreateComponent],
    imports: [
        CommonModule,
        ContractRoutingModule,
        FormsModule,
        RouterModule,
        ReactiveFormsModule,
        MatDialogModule,
        AngularFireModule.initializeApp(environment.firebaseConfig),
        NgxSpinnerModule,
    ],
  providers: [DatePipe]
})
export class ContractModule { }
