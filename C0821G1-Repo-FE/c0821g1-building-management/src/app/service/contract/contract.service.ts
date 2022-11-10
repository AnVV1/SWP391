import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contract} from '../../model/contract/contract';
import {ContractDto} from '../../model/contract/contract-dto';


@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private API = 'http://localhost:8080/api/contract';

  constructor(private httpClient: HttpClient) { }
  // list-search-page
  findAllContract(page, name, code, start, end): Observable<any> {
    return this.httpClient.get(this.API + '/contract-list?page=' + page + '&name=' + name
      + '&code=' + code + '&start=' + start  + '&end=' + end);
  }

  getContractById(contractId): Observable<Contract> {
    return this.httpClient.get(this.API + '/' + contractId);
  }

  getContractById1(contractId): Observable<any> {
    return this.httpClient.get(this.API + '/find/' + contractId);
  }

  deleteContract(contractId): Observable<any> {
    return this.httpClient.delete(this.API + '/delete-contract/' + contractId);
  }


  updateContract(id: number, contract: ContractDto): Observable<Contract> {
    console.log(id + 'contract' + contract);
    return this.httpClient.patch<ContractDto>(`${this.API}/update/${id}`, contract);
  }

  saveContract(contract): Observable<ContractDto> {
    // console.log(contract);
    return this.httpClient.post<ContractDto>(this.API + '/add', contract);
  }

  checkDate(date, date1): Observable<boolean> {
    return this.httpClient.get<boolean>(this.API + '/check?date1=' + date + '&date2=' + date1);
  }
}
