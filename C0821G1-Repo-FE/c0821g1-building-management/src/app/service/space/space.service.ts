import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SpacesList} from '../../model/space/spaces-list';
import {environment} from '../../../environments/environment';
import {Spaces} from '../../model/space/spaces';
import {Customer} from '../../model/customer/customer';
import {Spacedto} from '../../model/contract/spacedto';

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class SpaceService {

  constructor(private httpClient: HttpClient) {
  }

  saveNewSpace(newSpace: Spaces): Observable<void> {
    return this.httpClient.post<void>(API_URL + '/spaces/create', newSpace);
  }

  findByID(id: number): Observable<Spaces> {
    return this.httpClient.get<Spaces>(API_URL + '/spaces/' + id);
  }

  getAllSpaces(): Observable<Spacedto[]> {
    return this.httpClient.get<Spacedto[]>(API_URL + '/spaces/list-select');
  }


  findAllSpace(): Observable<SpacesList[]> {
    return this.httpClient.get<SpacesList[]>(API_URL + '/spaces/list');
  }

  searchSpace(floorName: string,
              spaceCode: string,
              spaceArea: string,
              spaceTypeName: string,
              spaceStatusName: string): Observable<SpacesList[]> {
    return this.httpClient.get<SpacesList[]>(API_URL + '/spaces/search?floorName=' +
      floorName + '&spaceCode=' +
      spaceCode + '&spaceArea=' +
      spaceArea + '&spaceTypeName=' +
      spaceTypeName + '&spaceStatusName=' +
      spaceStatusName);
  }

  deleteSpaceById(spaceId: number): Observable<SpacesList> {
    return this.httpClient.get<SpacesList>(API_URL + `/spaces/delete/${spaceId}`);
  }

  getSpaceById(spaceId: number): Observable<any> {
    return this.httpClient.get(API_URL + `/spaces/detail/${spaceId}`);
  }
  editSpace(spaceEdit: Spaces): Observable < void > {
    return this.httpClient.patch<void>(API_URL + '/spaces/edit/' + spaceEdit.spaceId, spaceEdit);
  }
}
