import {Component, OnInit} from '@angular/core';
import {Contract} from '../../../model/contract/contract';
import {ContractService} from '../../../service/contract/contract.service';
import {Subscription} from 'rxjs';
import {MatDialog} from '@angular/material/dialog';
import {ContractDeleteComponent} from '../contract-delete/contract-delete.component';
import {Route, Router} from '@angular/router';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {NgxSpinnerService} from 'ngx-bootstrap-spinner';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  checkDeleteFlag = false;

  constructor(
    private contractService: ContractService,
    private dialog: MatDialog,
    private router: Router,
    private tokenStorageService: TokenStorageService,
    private snipper: NgxSpinnerService
  ) {

    const user1 = this.tokenStorageService.getUser().roles[0];
    console.log(user1);
    if (user1 === 'ROLE_EMPLOYEE') {
      this.checkDeleteFlag = true;
      console.log(this.checkDeleteFlag);
    }
  }

  contract: Contract[] = [];
  private subscription: Subscription | undefined;
  page = 0;
  name = '';
  code = '';
  start = '';
  end = '';
  totalPages: number;
  pageNumber: number;
  size = 0;
  flagSearch = false;
  message: string;

  ngOnInit(): void {
    this.contractService.findAllContract(this.page, '', '', '', '').subscribe(data => {
      if (data === null) {
        this.message = 'Not found !!!';
        console.log(this.message);
      } else {
        this.contract = data.content;
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber;
        this.size = data.size;
        this.page = data.pageable.pageNumber;
        this.message = '';
        for (const contract1 of this.contract) {
          // @ts-ignore
          const dateEnd = new Date(contract1.contractDateEnd);
          // @ts-ignore
          const today = new Date();
          // @ts-ignore
          const endDate1 = new Date(dateEnd.getFullYear(), dateEnd.getDate(), dateEnd.getMonth());
          // @ts-ignore
          const check = endDate1 - today;
          contract1.checkFlag = Math.round(check);
          console.log(this.message);
        }
      }
    });
  }

  onSubmit() {
    this.flagSearch = false;
    this.showContract();
  }

  showContract() {
    if (this.name === '' && this.code === '' && this.start === '' && this.end === '') {
      this.flagSearch = false;
      this.getContract();
    } else if (this.name !== '' && this.code === '' && this.start === '' && this.end === '') {
      this.searchContract();
    } else if (this.name !== '' && this.code !== '' && this.start === '' && this.end === '') {
      this.searchContract();
    } else if (this.name !== '' && this.code !== '' && this.start !== '' && this.end === '') {
      this.searchContract();

    } else if (this.name !== '' && this.code !== '' && this.start !== '' && this.end !== '') {
      this.searchContract();
    } else if (this.name !== '' && this.code === '' && this.start !== '' && this.end === '') {
      this.searchContract();
    } else if (this.name === '' && this.code === '' && this.start === '' && this.end !== '') {
      this.searchContract();

    } else if (this.name === '' && this.code !== '' && this.start === '' && this.end === '') {
      this.searchContract();
    } else if (this.name === '' && this.code !== '' && this.start !== '' && this.end === '') {
      this.searchContract();
    } else if (this.name === '' && this.code !== '' && this.start === '' && this.end !== '') {
      this.searchContract();

    } else if (this.name === '' && this.code !== '' && this.start !== '' && this.end !== '') {
      this.searchContract();
    } else if (this.name === '' && this.code === '' && this.start !== '' && this.end === '') {
      this.searchContract();
    } else if (this.name === '' && this.code === '' && this.start !== '' && this.end !== '') {
      this.searchContract();

    } else if (this.name === '' && this.code === '' && this.start === '' && this.end !== '') {
      this.searchContract();
    }
  }

  getContract() {
    this.contractService.findAllContract(this.page, this.name, this.code, this.start, this.end).subscribe(data => {
        console.log('data ====> ' + data);
        this.snipper.show();
        if (data !== null) {
          this.contract = data.content;
          this.totalPages = data.totalPages;
          this.pageNumber = data.pageable.pageNumber;
          this.size = data.size;
          this.page = data.pageable.pageNumber;
          this.message = '';
          for (const contract1 of this.contract) {
            // @ts-ignore
            const dateEnd = new Date(contract1.contractDateEnd);
            // @ts-ignore
            const today = new Date();
            // @ts-ignore
            const endDate1 = new Date(dateEnd.getFullYear(), dateEnd.getDate(), dateEnd.getMonth());
            // @ts-ignore
            const check = endDate1 - today;
            contract1.checkFlag = Math.round(check);
            console.log(this.message);
            console.log('check ' + check);
          }
        } else {
          this.message = 'Not found !!!';
          console.log(this.message);
        }
      },
      () => {
      }, () => {
        setTimeout(() => {
          /** spinner ends after 5 seconds */
          this.snipper.hide();
        }, 1000);
      });
  }

  searchContract() {
    if (this.flagSearch === false) {
      this.page = 0;
      this.getContract();
      this.flagSearch = true;
    } else {
      this.getContract();
      this.flagSearch = true;
    }
  }

  openDialog(contractId) {
    this.contractService.getContractById(contractId).subscribe(contractData => {
      const dialogRef = this.dialog.open(ContractDeleteComponent, {
        width: '500px',
        data: {contractData},
        disableClose: true
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('the dialog was closed');
        this.ngOnInit();
      });
    });
  }

  previousClick(index) {
    this.page = this.page - index;
    console.log('pre pay ' + this.page + '/' + this.totalPages + 'search:' + this.flagSearch);
    this.ngOnInit();
  }

  nextClick(index) {
    this.page = this.page + index;
    console.log('next pay ' + this.page + '/' + this.totalPages + 'search:' + this.flagSearch);
    this.ngOnInit();
  }


  findPaginnation(value: number) {
    this.page = value - 1;
    this.ngOnInit();
  }

  // getAll(){
  //   this.contractService.findAllContract().subscribe(c => {
  //     this.contracts = c;
  //   });
  // }
  toCreateForm() {
    this.router.navigate(['contract/create']);
  }

  editContract(contractId: number) {
    this.router.navigate(['contract/edit/' + contractId]);
  }
}
