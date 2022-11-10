import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SpacesStatus} from '../../model/space/spaces-status';

@Injectable({
  providedIn: 'root'
})
export class SpaceStatusService {
  API_URL = 'http://localhost:8080/api/spaceStatus/list';
  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<SpacesStatus[]>{
    return this.httpClient.get<SpacesStatus[]>(this.API_URL);
  }
}
