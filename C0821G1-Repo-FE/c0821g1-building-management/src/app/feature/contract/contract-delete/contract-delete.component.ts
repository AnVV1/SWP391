import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ContractService} from '../../../service/contract/contract.service';
import {Contract} from '../../../model/contract/contract';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-contract-delete',
  templateUrl: './contract-delete.component.html',
  styleUrls: ['./contract-delete.component.css']
})
export class ContractDeleteComponent implements OnInit {

  contract: Contract;
  constructor(public  dialogRef: MatDialogRef<ContractDeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private contractService: ContractService) {

  }

  ngOnInit(): void {
    this.contract = this.data.contractData;
  }

  deleteContract(){
    console.log(this.contract.contractId);
    this.contractService.deleteContract(this.contract.contractId).subscribe(date => {
      this.dialogRef.close();
      this.callToast();
    });
  }
  private callToast() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Xóa hợp đồng thành công!',
      showConfirmButton: false,
      timer: 5000
    });
  }
}
