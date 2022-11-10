import {Component, Inject, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeePosition} from '../../../model/employee/employee-position';
import {EmployeeService} from '../../../service/employee/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeePositionService} from '../../../service/employee/employee-position.service';
import {Employee} from '../../../model/employee/employee';
import Swal from 'sweetalert2';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {TokenStorageService} from '../../../service/security/token-storage.service';


@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  validateCode: string;
  employeePositionList: Array<EmployeePosition>;
  employeeEdit: Employee;
  private selectedImage: any;
  loading = false;
  employee: Employee;
  id: any;

  employeeEditForm = new FormGroup({
    employeeCode: new FormControl('', [Validators.required, Validators.pattern('[N][V][-]\\d{4}')]),
    employeeName: new FormControl('', [Validators.required, Validators.maxLength(40),
      Validators.pattern('^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$')]),
    employeeDateOfBirth: new FormControl('', [Validators.required, this.checkMinAge]),
    employeeAddress: new FormControl('', [Validators.required, Validators.maxLength(40)]),
    employeeEmail: new FormControl(''),
    employeePhone: new FormControl('', [Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
    employeeStartDate: new FormControl('', Validators.required),
    employeeGender: new FormControl(),
    employeePosition: new FormControl('', Validators.required),
    employeeImage: new FormControl('')
  });

  constructor(private employeeService: EmployeeService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private employeePositionService: EmployeePositionService,
              private activatedRoute: ActivatedRoute,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {
    // this.id =  this.tokenStorageService.getUser().idEmployee;
    // console.log('------------------' + this.id);
    // // const employeeId = this.activatedRoute.snapshot.params.id;
    // this.employeeService.findById(Number(this.id)).subscribe(value => {
    //   console.log(value);
    //   this.employee = value;
    //   this.employeeEditForm.patchValue(
    //     this.employee
    //   );
    // });

  }

  ngOnInit(): void {

    this.employeePositionService.findAllEmployeePosition().subscribe(value => {
      this.employeePositionList = value;
      console.log(this.employeePositionList);

      const employeeEditId = this.activatedRoute.snapshot.params.id;
      this.id = employeeEditId;
      console.log(employeeEditId);
      this.employeeService.findById(employeeEditId).subscribe(value2 => {
        this.employeeEdit = value2;
        console.log(this.employeeEdit);
        this.employeeEditForm.patchValue(
          this.employeeEdit
        );
      });
    });
  }
  get employeeImage() {
    return this.employeeEditForm.get('employeeImage');
  }
  editEmployee() {
    const editEmployee = Object.assign({}, this.employeeEditForm.value);
    editEmployee.employeeId = this.employeeEdit.employeeId;
    editEmployee.appUser = this.employeeEdit.appUser;
    editEmployee.employeeDeleteFlag = this.employeeEdit.employeeDeleteFlag;
    this.employeeService.editEmployee(editEmployee).subscribe(value => {
        this.callToast();
      },
      error => {
        console.log(error);
        this.validateCode = error.error.code;
        alert(this.validateCode);
      }, () => {
        this.router.navigateByUrl('/employee/list');
      });
  }
  private callToast() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Sửa mới thành công!',
      showConfirmButton: false,
      timer: 2000
    });
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
    const nameImg = this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.loading = true;
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.employeeEditForm.patchValue({employeeImage: url});
          this.employee.employeeImage = url;
          this.loading = false;
        });
      })
    ).subscribe();
  }
  checkMinAge(abstractControl: AbstractControl): any {
    const dateOfBirth = abstractControl.value;
    const yearOfBirth = dateOfBirth.substr(0, 4);
    const currentYear = new Date().getFullYear();
    return currentYear - yearOfBirth >= 18 ? null : {under18: true};
  }
}
