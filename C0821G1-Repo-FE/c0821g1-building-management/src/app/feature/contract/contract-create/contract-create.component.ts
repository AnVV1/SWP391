import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../../../service/contract/contract.service';
import {Router} from '@angular/router';
import {SpaceService} from '../../../service/space/space.service';
import {EmployeeService} from '../../../service/employee/employee.service';

import {CustomerService} from '../../../service/customer/customer.service';
import {DatePipe} from '@angular/common';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import Swal from 'sweetalert2';
import {UploadFileService} from '../../../service/upload-file-image/upload-file.service';
import {Spaces} from '../../../model/space/spaces';
import {Customer} from '../../../model/customer/customer';
import {Employee} from '../../../model/employee/employee';
import {Spacedto} from '../../../model/contract/spacedto';
import {TokenStorageService} from '../../../service/security/token-storage.service';


@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  selectedImage: any = null;
  url: '';
  id: string;
  file: string;
  checkCode: boolean;
  checkDate: boolean;
  spaceCode: string;

  contractsForm: FormGroup = this.fb1.group({
    contractId: '',
    contractCode: ['', [Validators.required, Validators.pattern('^[H][D]-[\\d]{4}$')]],
    contractExpired: ['', [Validators.required]],
    contractDateStart: ['', [Validators.required]],
    contractDateEnd: ['', [Validators.required]],
    price: ['', [Validators.required]],
    contractTotal: ['', [Validators.required]],
    contractContent: ['', [Validators.required, Validators.minLength(10)]],
    contractTaxCode: ['', [Validators.required, Validators.pattern('^[\\d]+$')]],
    contractDeposit: ['', [Validators.required]],
    contractImageUrl: ['', [Validators.required]],
    contractDeleteFlag: false,
    employeeId: '',
    customerId: ['', [Validators.required]],
    spaceId: ['', [Validators.required]],
    checkFlag: 0
  });

  spaces: Spacedto[];
  employees: Employee[];
  customers: Customer[];

  dateStart: string;
  dateEnd: string;
   employeeId: number;
   price: any;
   totalPrice: number;
   deposit: any;
   name1: string;
   code1: string;


  constructor(private fb1: FormBuilder,
              private contractService: ContractService,
              private spaceService: SpaceService,
              private employeeService: EmployeeService,
              private customerService: CustomerService,
              private router: Router,
              private  datepipe: DatePipe,
              private tokenStorageService: TokenStorageService,
              @Inject(AngularFireStorage) private storage: AngularFireStorage,
              @Inject(UploadFileService) private uploadFileService: UploadFileService
  ) {
    // this.spaces = spaceService.spaces;
    // this.employees = employeeService.employees;
    // this.customers = customerService.customers;
    this.checkCode = false;

    this.employeeId =  this.tokenStorageService.getUser().idEmployee;
    this.contractsForm.controls.employeeId.patchValue(this.employeeId);
    console.log('xong' + this.contractsForm.controls.employeeId.value);
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data;
    });

    this.spaceService.getAllSpaces().subscribe(data => {
      this.spaces = data;
    });

  }

  ngOnInit(): void {
    this.uploadFileService.getImageDetailList();
  }

  callToast() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Thêm mới thành công',
      showConfirmButton: false,
      timer: 2000
    });
  }



  submit() {

    console.log('contract/list' + this.contractsForm.controls.customerId.value);



    const name = this.selectedImage.name;
    const fileRef = this.storage.ref(name);
    this.storage.upload(name, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          console.log(url);
          this.contractsForm.patchValue({contractImageUrl: url});
          const contract = this.contractsForm.value;
          this.dateStart = contract.contractDateStart;
          this.dateEnd = contract.contractDateEnd;
          // @ts-ignore
          const date1 = new Date(contract.contractDateStart);
          // @ts-ignore
          const date2 = new Date(contract.contractDateEnd);
          const month = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24 * 30);
          // @ts-ignore
          // contract.contractExpired = Math.round(month);
          this.changeId();
          this.contractService.saveContract(contract).subscribe(() => {
            this.contractsForm.reset();
            this.callToast();
            this.router.navigate(['contract/list']);
          }, err => {
            console.log(err);
            // this.validateErrorCode = err.error.code;
            // alert('Mã hợp đồng đã tồn tại');
            this.checkCode = true;
          });
        });
      })
    ).subscribe();
  }

  changeId(id){
      this.contractsForm.controls.customerId.patchValue(id);
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
    if (event.target.files) {
      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      // tslint:disable-next-line:no-shadowed-variable
      reader.onload = (event: any) => {
        this.url = event.target.result;
      };
    }
  }

  // checkDate1(date1, date2) {
  //   this.contractService.checkDate(date1, date2).subscribe(result => {
  //     console.log(result);
  //     console.log(this.contractsForm.controls.contractDateStart.value);
  //     console.log(this.contractsForm.controls.contractDateEnd.value);
  //     if (result) {
  //       this.checkDate = true;
  //     } else {
  //       this.checkDate = false;
  //     }
  //   });
  // }

  checkDate1(date1, date2, price) {

    console.log('dateStart : ' + date1);
    console.log('dateEnd : ' + date2);
    console.log('price : ' + price);

    this.price = price;

    if (date1 !== '' && date2 !== '' && price === '') {
      this.contractService.checkDate(date1, date2).subscribe(result => {
        // console.log(result);
        // console.log(this.contractsForm.controls.contractDateStart.value);
        // console.log(this.contractsForm.controls.contractDateEnd.value);
        const dateStart = new Date(date1);
        // @ts-ignore
        const dateEnd = new Date(date2);
        const month = (dateEnd.getTime() - dateStart.getTime()) / (1000 * 3600 * 24 * 30);
        // @ts-ignore
        // contract.contractExpired = Math.round(month);
        this.contractsForm.controls.contractExpired.patchValue(Math.round(month));

        if (result) {
          this.checkDate = true;
        } else {
          this.checkDate = false;
        }
      });
    }

    if (date1 !== '' && date2 !== '' && price !== '') {

      const dateStart = new Date(date1);
      // @ts-ignore
      const dateEnd = new Date(date2);
      const month = (dateEnd.getTime() - dateStart.getTime()) / (1000 * 3600 * 24 * 30);
      // @ts-ignore
      // contract.contractExpired = Math.round(month);
      this.contractsForm.controls.contractExpired.patchValue(Math.round(month));

      // tslint:disable-next-line:radix
      this.totalPrice = parseInt(this.contractsForm.controls.contractExpired.value)  * parseInt(price);
      this.contractsForm.controls.contractTotal.patchValue(this.totalPrice);
    }
  }

  changeDeposit() {
    this.deposit = this.contractsForm.controls.contractDeposit.value;
  }

  name(){

     // this.contractsForm.controls.customerId.value;
     for (let i = 0 ; i < this.customers.length - 1 ; i ++){
       //
       // console.log( parseInt(this.contractsForm.controls.customerId.value + 'id'));
       // console.log(this.customers[i].customerId);

       if ( parseInt(this.contractsForm.controls.customerId.value) === this.customers[i].customerId){
         console.log('name' + this.customers[i].customerName);
        // tslint:disable-next-line:no-unused-expression
         this.name1 = this.customers[i].customerName;
         this.code1 = this.customers[i].customerIdentifyNumber;
      }
    }
  }

  code(){
    for (let i = 0 ; i < this.spaces.length - 1 ; i ++){
      //
      // console.log( parseInt(this.contractsForm.controls.customerId.value + 'id'));
      // console.log(this.customers[i].customerId);

      // tslint:disable-next-line:radix
      if ( parseInt(this.contractsForm.controls.spaceId.value) === this.spaces[i].spaceId){
        console.log('name' + this.customers[i].customerName);
        // tslint:disable-next-line:no-unused-expression
        this.spaceCode = this.spaces[i].spaceCode;

      }
    }
  }
}
