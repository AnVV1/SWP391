import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';
import {UserService} from '../../../service/employee/user.service';
import {UserDto} from '../../../model/user/user-dto';
import {EmployeeService} from '../../../service/employee/employee.service';
import {Employee} from '../../../model/employee/employee';

@Component({
  selector: 'app-employee-edit-password',
  templateUrl: './employee-edit-password.component.html',
  styleUrls: ['./employee-edit-password.component.css']
})
export class EmployeeEditPasswordComponent implements OnInit {

  changePasswordForm: FormGroup;
  id: number;
  employeeEdit: Employee;

  constructor(private userService: UserService,
              private router: Router,
              private employeeService: EmployeeService,
              private activatedRoute: ActivatedRoute,
  ) {
    this.changePasswordForm = new FormGroup({
      id: new FormControl(),
      currentPassword: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(10)]),
      newPassword: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(10), this.checkPassword]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(10), this.checkPassword])
    });

    const employeeEditId = this.activatedRoute.snapshot.params.id;
    this.changePasswordForm.controls.id.patchValue(employeeEditId);
    this.employeeService.findById(employeeEditId).subscribe(value2 => {
      this.id = employeeEditId;
      this.employeeEdit = value2;
      console.log(this.employeeEdit);
      this.changePasswordForm.patchValue(
        this.employeeEdit
      );
    });
  }

  ngOnInit(): void {
  }

  edit(userDTO: UserDto, id: any) {
    console.log('null ne ' + id);
    userDTO = Object.assign({}, this.changePasswordForm.value);
    console.log(userDTO);
    if (this.changePasswordForm.controls.id.value) {
    this.userService.updateUser(userDTO).subscribe(value => {
      this.callToast();
    }, error => {
      this.callToast1();
    }, () => {
    });
    }
    console.log(userDTO);
  }

  private callToast() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Đổi mật khẩu thành công!😍',
      showConfirmButton: false,
      timer: 2000
    });
  }

  private callToast1() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Đổi mật khẩu thất bại!😥',
      showConfirmButton: false,
      timer: 2000
    });
  }

  checkPassword(abstractControl: AbstractControl): any {
    console.log('c' + abstractControl.value);
    console.log('a ' + abstractControl.value.newPassword);
    console.log('b ' + abstractControl.value.confirmPassword);
    return abstractControl.value.newPassword === abstractControl.value.confirmPassword ? null : {wrongPassword: true};
  }
}
