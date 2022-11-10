import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SpacesType} from '../../model/space/spaces-type';

@Injectable({
  providedIn: 'root'
})
export class SpaceTypeService {
  API_URL = 'http://localhost:8080/api/spaceType/list';

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<SpacesType[]>{
    return this.httpClient.get<SpacesType[]>(this.API_URL);
  }
}
