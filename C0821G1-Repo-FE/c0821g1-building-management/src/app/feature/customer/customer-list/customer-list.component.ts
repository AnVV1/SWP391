import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomerService} from '../../../service/customer/customer.service';
import {Subscription} from 'rxjs';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {MatDialog} from '@angular/material/dialog';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customerDelete: Customer;
  private subscription: Subscription | undefined;
  page = 0;
  // tslint:disable-next-line:variable-name
  customer_name = '';
  // tslint:disable-next-line:variable-name
  customer_email = '';
  // tslint:disable-next-line:variable-name
  customer_identify_number = '';
  // tslint:disable-next-line:variable-name
  customer_phone = '';
  totalPages: number;
  pageNumber: number;
  size = 0;
  flag = false;
  message: string;

  constructor(private customerService: CustomerService,
              private dialogDelete: MatDialog) {
  }

  ngOnInit(): void {
    this.customerService.search(this.page, this.customer_name, this.customer_identify_number, this.customer_phone, this.customer_email)
      .subscribe(data => {
          console.log(data);
          if (data !== null) {
            this.customers = data.content;
            this.totalPages = data.totalPages;
            this.size = data.size;
            this.page = data.pageable.pageNumber;
            this.message = '';
          }
        }
      );
  }

  // VyLTT - search customer
  search() {
    if (this.customer_name === '' && this.customer_email === '' && this.customer_identify_number === '' && this.customer_phone === '') {
      this.flag = false;
      this.customerService.search(this.page, this.customer_name, this.customer_identify_number, this.customer_phone, this.customer_email)
        .subscribe(data => {
            console.log(data);
            if (data !== null) {
              this.customers = data.content;
              this.totalPages = data.totalPages;
              this.size = data.size;
              this.page = data.pageable.pageNumber;
              this.message = '';
            } else {
              this.message = 'Không tìm thấy khách hàng cần tìm !!!';
            }
          }
        );
    } else {
      if (this.flag === false) {
        this.page = 0;
        this.customerService.search(this.page, this.customer_name, this.customer_identify_number, this.customer_phone, this.customer_email)
          .subscribe(data => {
            if (data !== null) {
              this.customers = data.content;
              this.totalPages = data.totalPages;
              this.size = data.size;
              this.page = data.pageable.pageNumber;
              this.message = '';
            } else {
              this.message = 'Không tìm thấy khách hàng cần tìm !!!';
            }
            this.flag = true;
          });
      }
    }
  }

  onSubmit() {
    this.flag = false;
    this.search();
  }

  // VyLTT - Pagination
  previousClick(index) {
    this.page = this.page - index;
    this.ngOnInit();
  }

  findPagination(value: number) {
    if (value > this.totalPages) {
      this.message = 'Không tìm thấy trang bạn cần tìm !!!';
    } else {
      this.page = value - 1;
      this.ngOnInit();
    }
  }

  nextClick(index) {
    this.page = this.page + index;
    this.ngOnInit();
  }

  openDialog(customerObjId: number) {
    this.customerService.getCustomerById(customerObjId).subscribe(customerData => {
      const dialogRef = this.dialogDelete.open(CustomerDeleteComponent, {
        width: '500px',
        data: customerData,
        disableClose: true
      });
      dialogRef.afterClosed().subscribe(value => {
        this.ngOnInit();
      });
    });
  }
}
