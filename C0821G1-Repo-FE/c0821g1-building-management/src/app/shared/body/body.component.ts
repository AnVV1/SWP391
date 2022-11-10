import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {Floors} from '../../model/floors/floors';
import {MatDialog} from '@angular/material/dialog';
import {FloorService} from '../../service/floor/floor.service';
import {FloorsDeleteComponent} from '../../feature/floor/floors-delete/floors-delete.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  urlImg: any;
  username: string;
  email: string;
  name: string;
  phone: string;
  address: string;
  gender: string;
  dateOfBirth: string;
  id: any;
  floorsList: Floors[] = [];
  floorsDTO: string;
  checkDeleteFlag = false;
  constructor( private tokenStorageService: TokenStorageService, private floorService: FloorService,
               private dialogDelete: MatDialog) {
    this.floorService.findAll().subscribe(value => {
      this.floorsList = value;
    }, error => {
    }, () => {
    });
    this.floorService.findFloorsDTO().subscribe(value => {
      this.floorsDTO = value;
    }, error => {
    }, () => {
    });

  }

  ngOnInit(): void {
   this.urlImg =  this.tokenStorageService.getUser().urlImg;
   this.id =  this.tokenStorageService.getUser().idEmployee;
   this.username = this.tokenStorageService.getUser().username;
   this.email = this.tokenStorageService.getUser().email;
   this.name = this.tokenStorageService.getUser().name;
   this.phone = this.tokenStorageService.getUser().phone;
   this.address = this.tokenStorageService.getUser().address;
   this.gender = this.tokenStorageService.getUser().gender;
   this.dateOfBirth = this.tokenStorageService.getUser().dayOfBirth;
   if (this.email !== null) {
      this.checkDeleteFlag = true;
      // console.log(this.checkDeleteFlag);
      // console.log(this.email);
    }
  }
  openDialog(floorId: number) {
    this.floorService.findById(floorId).subscribe(value => {
        const dialogRef = this.dialogDelete.open(FloorsDeleteComponent, {
          width: '500px',
          data: {value},
          disableClose: true
        });
        dialogRef.afterClosed().subscribe(value1 => {
          this.ngOnInit();
        });
      },
      error => {
        this.callToastFail();
      });
  }

  private callToastFail() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Không tìm thấy tầng lầu hoặc tầng lầu đã bị xóa 🙄!',
      showConfirmButton: false,
      timer: 2000
    });
  }

  private callToastFailList() {
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Không tìm thấy dữ liệu 🤷‍♂️🤷‍♂️🤷‍♂ !',
      showConfirmButton: false,
      timer: 2000
    });
  }
}
