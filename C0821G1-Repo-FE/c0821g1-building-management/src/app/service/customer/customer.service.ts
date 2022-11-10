import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../../model/customer/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  // VyLTT
  private API_URL = 'http://localhost:8080/api/customer';

  constructor(private httpClient: HttpClient) {
  }

  // VyLTT - get by id
  getCustomerById(customerId: number): Observable<any> {
    return this.httpClient.get<Customer>(this.API_URL + '/' + customerId);
  }

  // VyLTT - get list customer
  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL + '/list-select');
  }

  // VyLTT - search customer by name, identify number, email, phone
  search(page, customerName, customerIdentifyNumber, customerPhone, customerEmail): Observable<any> {
    return this.httpClient.get(this.API_URL + '/search?page=' + page +
      '&customer_name=' + customerName +
      '&customer_identify_number=' + customerIdentifyNumber +
      '&customer_phone=' + customerPhone +
      '&customer_email=' + customerEmail);
  }

  // VyLTT - delete customer
  deleteCustomerById(deleteId: number): Observable<any> {
    return this.httpClient.delete<void>(this.API_URL + '/delete/' + deleteId);
  }
}
