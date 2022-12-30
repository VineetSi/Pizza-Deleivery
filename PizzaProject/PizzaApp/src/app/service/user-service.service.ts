import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }

  post(data: any): Observable<any> {
    return this.http.post(`http://localhost:9000/api/v2/register`, data)
  }
}
