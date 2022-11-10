import {Component, OnInit} from '@angular/core';
import {SpacesList} from '../../../model/space/spaces-list';
import {SpaceService} from '../../../service/space/space.service';
import {MatDialog} from '@angular/material/dialog';
import {SpaceDeleteComponent} from '../space-delete/space-delete.component';
import {NgxSpinnerService} from 'ngx-bootstrap-spinner';

const FILTER_PAG_REGEX = /[^0-9]/g;

@Component({
  selector: 'app-space-list',
  templateUrl: './space-list.component.html',
  styleUrls: ['./space-list.component.css']
})
export class SpaceListComponent implements OnInit {

  checkDelete = false;
  spaceId: number;
  spaceCodeDelete: string;
  spaceList: SpacesList[];
  page = 1;
  pageSize = 5;
  collectionSize = 0;
  totalPages: number;
  checkListSearchEmpty: any;
  messageError: string;

  constructor(private spaceService: SpaceService,
              private dialogDelete: MatDialog,
              private snipper: NgxSpinnerService) {
  }

  ngOnInit(): void {
    this.findAllSpace();
  }

  selectPage(event: any) {
    this.page = parseInt(event.target.value, 10) || 1;
  }

  counter(i: number) {
    return new Array(i);
  }

  findAllSpace() {
    this.spaceService.findAllSpace().subscribe(data => {
      console.log(data);
      this.messageError = '';
      this.snipper.show();
      if (data == null) {
        this.spaceList = [];
        this.collectionSize = 0;
        this.messageError = 'Không tìm thấy dữ liệu.';
      } else {
        this.spaceList = data['content'];
        this.collectionSize = data['totalElements'];
        if (this.collectionSize % this.pageSize !== 0){
          this.totalPages = Math.floor(this.collectionSize / this.pageSize) + 1;
        } else {
          this.totalPages = Math.floor(this.collectionSize / this.pageSize);
        }
      }
    }, () => {
    }, () => {
      setTimeout(() => {
        /** spinner ends after 5 seconds */
        this.snipper.hide();
      }, 1000);
    });
  }

  passData(id: number, code: string) {
    this.checkDelete = true;
    this.spaceId = id;
    this.spaceCodeDelete = code;
  }

  delete() {
    this.spaceService.deleteSpaceById(this.spaceId).subscribe(() => {
      this.findAllSpace();
      if (this.spaceList.length <= 1) {
        location.reload();
      }
    });
  }

  search(floorName: string, spaceCode: string, spaceArea: string, spaceTypeName: string, spaceStatusName: string) {
    if (floorName === '' && spaceCode === '' && spaceArea === '' && spaceTypeName === '' && spaceStatusName === '') {
      return this.findAllSpace();
    } else {
      this.page = 1;
      return this.spaceService.searchSpace(floorName, spaceCode, spaceArea, spaceTypeName, spaceStatusName).subscribe(result => {
        this.messageError = '';
        this.snipper.show();
        if (result == null) {
          this.spaceList = [];
          this.collectionSize = 0;
          this.messageError = 'Không tìm thấy dữ liệu.';
        } else {
          this.spaceList = result['content'];
          this.collectionSize = result['totalElements'];
          if (this.collectionSize % this.pageSize !== 0){
            this.totalPages = Math.floor(this.collectionSize / this.pageSize) + 1;
          } else {
            this.totalPages = Math.floor(this.collectionSize / this.pageSize);
          }
        }
      }, () => {
      }, () => {
        setTimeout(() => {
          /** spinner ends after 5 seconds */
          this.snipper.hide();
        }, 1000);
      });
    }
  }

  previousClick() {
    this.page = this.page - 1;
  }

  nextClick() {
    this.page = this.page + 1;
  }

  openDialog(spaceId: number) {
    this.spaceService.getSpaceById(spaceId).subscribe(spaceData => {
      const dialogRef = this.dialogDelete.open(SpaceDeleteComponent, {
        width: '500px',
        data: {spaceData},
        disableClose: true
      });
      dialogRef.afterClosed().subscribe(value => {
        this.ngOnInit();
      });
    });
  }
}
