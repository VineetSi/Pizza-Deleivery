import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserLogin } from '../class/user-login';
import { HomeCompComponent } from '../home-comp/home-comp.component';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private service:LoginService) { }

  ngOnInit(): void {
   
   
  }
  
  myuser:UserLogin=new UserLogin("","");
  data:any;

  profileForm = new FormGroup({
    user : new FormControl('', [Validators.required]),
    pass : new FormControl('', [Validators.required])
  })
  getuserid() {
    return this.profileForm.controls.user
    }

  getpassword() {
    return this.profileForm.controls.pass
  }
  hide = true;
    onsubmit(){
      console.log(this.myuser.userId);
      console.log(this.myuser.userPassword);
      this.service.login(this.myuser).subscribe(c=>{
        console.log(c)
        this.data=c
        sessionStorage.setItem("token",this.data.token)
        if(this.data == null){
          window.alert("credentials did not match, Try Again!")
        }else{
          window.alert("WELCOME"+" "+this.myuser.userId)
          this.service.isUserLogin()
          this.router.navigateByUrl("/");
        }
      });
    }
  
  
}
