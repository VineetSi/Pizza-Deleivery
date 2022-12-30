import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User1 } from '../class/User1';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router:Router,private service:UserServiceService) { }


  registeredUser:User1=new User1("","","","");

  ngOnInit(): void {
  }

  hide = true;

    register= new FormGroup({
    userName:new FormControl('',[Validators.required]),
    userEmailId:new FormControl('',[Validators.required,Validators.email]) ,
    userPassword:new FormControl('',[Validators.required])})
    
  getEmailId(){
    return this.register.controls.userEmailId
  }
  getusername() {
    return this.register.controls.userName
    }
  getuserId() {
      return this.register.controls.userName
      }

  getpassword() {
    return this.register.controls.userPassword
  }
  onsubmit(){
    this.service.post(this.registeredUser).subscribe(
      data=>console.log(data)
    )
    console.log(this.registeredUser.userEmailId);
    console.log(this.registeredUser.userId);
    console.log(this.registeredUser.userName);
    console.log(this.registeredUser.userPassword);
    
    alert("register successfully")
   this.router.navigateByUrl('/login')
  }
}
