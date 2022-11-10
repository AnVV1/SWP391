import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../../model/employee/employee';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


  API_URL = 'http://localhost:8080/api/employee';


  constructor(private http: HttpClient) {
  }


  getEmployee(id: number): Observable<any> {
    return this.http.get(this.API_URL + '/detail/' + id);
  }

  search(page: number, employeeName: string, employeeDateOfBirth: string, employeeEmail: string,
         employeeAddress: string): Observable<any> {
    return this.http.get(this.API_URL + '/search?employeeName=' + employeeName + '&employeeDateOfBirth='
      + employeeDateOfBirth + '&employeeEmail=' + employeeEmail + '&employeeAddress=' + employeeAddress
      + '&page=' + page);
  }


  deleteEmployeeById(id: any): Observable<any> {
    return this.http.delete(this.API_URL + '/delete/' + id);
  }

  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.API_URL + '/detail/' + id);
  }

  saveNewEmployee(newEmployee: Employee): Observable<void> {
    return this.http.post<void>(this.API_URL + '/create', newEmployee);
  }

  editEmployee(employeeEdit: Employee): Observable<void> {
    return this.http.patch<void>(this.API_URL + '/update/' + employeeEdit.employeeId, employeeEdit);
  }

  findAllEmployee(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.API_URL + '/list');
  }
}
