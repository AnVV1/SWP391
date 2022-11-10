import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Floors} from '../../model/floors/floors';
import {FloorsDTO} from '../../model/floors-dto';

@Injectable({
  providedIn: 'root'
})
export class FloorService {
  API_URL = 'http://localhost:8080/api';
  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Floors[]> {
    return this.httpClient.get<Floors[]>(this.API_URL + '/floors/list');
  }
  findById(floorId: number): Observable<Floors> {
    return this.httpClient.get<Floors>(this.API_URL + '/floors/find-by-id/' + floorId);
  }
  deleteFlagFloors(floorId: number): Observable<Floors> {
    return this.httpClient.delete<Floors>(this.API_URL + '/floors/delete-flag/' + floorId);
  }
  findFloorsDTO() {
    return this.httpClient.get<string>(this.API_URL + '/floors/area');
  }
}
