import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../../service/employee/employee.service';
import {ActivatedRoute} from '@angular/router';
import {Employee} from '../../../model/employee/employee';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  employee: Employee ;
  gender: string;
  dateOfBirth: string;
  id: any;


  employeeForm = new FormGroup({
    employeeId: new FormControl(''),
    employeeCode: new FormControl(''),
    employeeName: new FormControl(''),
    employeeDateOfBirth: new FormControl(''),
    employeeAddress: new FormControl(''),
    employeeEmail: new FormControl(''),
    employeePhone: new FormControl(''),
    employeeGender: new FormControl(),
  });

  constructor(private employeeService: EmployeeService,
              private activatedRoute: ActivatedRoute,
              private tokenStorageService: TokenStorageService ) {
    this.id =  this.tokenStorageService.getUser().idEmployee;
    console.log('------------------' + this.id);
    // const employeeId = this.activatedRoute.snapshot.params.id;
    this.employeeService.findById(Number(this.id)).subscribe(value => {
      console.log(value);
      this.employee = value;
      this.employeeForm.patchValue(
        this.employee
      );
    });
  }

  ngOnInit(): void {
    // this.urlImg =  this.tokenStorageService.getUser().urlImg;
    // this.id =  this.tokenStorageService.getUser().idEmployee;
    // this.username = this.tokenStorageService.getUser().username;
    // this.employeeEmail = this.tokenStorageService.getUser().employeeEmail;
    // this.name = this.tokenStorageService.getUser().name;
    // this.employeePhone = this.tokenStorageService.getUser().employeePhone;
    // this.address = this.tokenStorageService.getUser().address;
    // this.gender = this.tokenStorageService.getUser().gender;
    // this.dateOfBirth = this.tokenStorageService.getUser().dayOfBirth;
    // throw new Error('Method not implemented.');
  }

}
