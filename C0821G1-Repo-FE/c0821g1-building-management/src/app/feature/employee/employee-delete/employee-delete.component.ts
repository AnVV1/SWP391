import {Component, Inject, OnInit} from '@angular/core';
import {Employee} from '../../../model/employee/employee';
import {Subscription} from 'rxjs';
import {EmployeeService} from '../../../service/employee/employee.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  employee: Employee;
  private subscription: Subscription;

  constructor(
    private employeeService: EmployeeService,
    public dialogRef: MatDialogRef<EmployeeDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  ngOnInit(): void {
    this.employee = this.data.employeeData;
  }

  deleteEmployee() {
    this.subscription = this.employeeService.deleteEmployeeById(this.employee.employeeId).subscribe(data => {
      this.dialogRef.close( false);
      this.callToast();
      // window.location.reload()
    });
  }

  private callToast() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Xóa nhân viên thành công!',
      showConfirmButton: false,
      timer: 2000
    });
  }

  onNoClick() {
    this.dialogRef.close();
  }
}
