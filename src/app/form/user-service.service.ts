import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  apiUrlEndpoint: string = '/user';
  baseUrl: string = environment.baseUrl;
  constructor( private httpClient : HttpClient) { }

  onAddUser(user :any):Observable<any>{
    return this.httpClient.post<any>(
      this.baseUrl.concat(this.apiUrlEndpoint),user
      );
  }
}
