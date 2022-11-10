import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EmployeePosition} from '../../model/employee/employee-position';

@Injectable({
  providedIn: 'root'
})
export class EmployeePositionService {
  API_URL = 'http://localhost:8080/api/employee-position/list';

  constructor(private httpClient: HttpClient) { }
  findAllEmployeePosition(): Observable<EmployeePosition[]>{
    return this.httpClient.get<EmployeePosition[]>(this.API_URL);
  }
}
