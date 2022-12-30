import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from '../class/user-login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  isLogin:boolean=false;
  user!:any
  
  login(data:any):Observable<any>{
    this.user=data;
    return this.http.post<any>(`http://localhost:9000/api/v1/login`, data)
    
  }

  isUserLogin():any{
    return this.isLogin=true;
  }

}
