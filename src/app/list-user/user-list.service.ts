import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserListService {
  apiUrlEndpoint: string = '/user';
  baseUrl: string = environment.baseUrl;

  constructor( private httpClient : HttpClient) { }

  listAllUsers():Observable<any>{
    return this.httpClient.get<any>(this.baseUrl.concat(this.apiUrlEndpoint))
  }


}
