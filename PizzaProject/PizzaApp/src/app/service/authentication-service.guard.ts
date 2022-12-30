import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginComponent } from '../login/login.component';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.isUsrLogin();
  }
  constructor(private loginServ:LoginService,private route:Router){}
  

  

  isUsrLogin(){
    if(this.loginServ.isLogin==true){
      return this.loginServ.isLogin;
    }
    else{
      return this.route.navigateByUrl("/login")
    }
      
    }
  }

