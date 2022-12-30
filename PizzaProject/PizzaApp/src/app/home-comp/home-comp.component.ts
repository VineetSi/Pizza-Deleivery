import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { PizzaCrudOpService } from '../service/pizza-crud-op.service';

@Component({
  selector: 'app-home-comp',
  templateUrl: './home-comp.component.html',
  styleUrls: ['./home-comp.component.css']
})
export class HomeCompComponent implements OnInit {

  constructor(private login:LoginService,private crud:PizzaCrudOpService ) { }

  ngOnInit(): void {
    this.loginButton();
  }
  count:number=0;
  isUserLoggedIn=true;

  onclick(num:number){
    if(this.login.isLogin==false){
      alert("Please Login first")
    }
    console.log(this.login.user.userId)
      this.crud.addOrder(num,this.login.user.userId).subscribe(c=>console.log(c))
     this.count=this.count+1;   
   
   }
   remove(num:number){
     if(this.count>0){
     this.count=this.count-1;
     this.crud.removeOrder(num,this.login.user.userId).subscribe(c=>console.log(c))
   }
  }
  getOrderData(){
    
  }
  

  loginButton(){
    if(this.login.isLogin==true)
    {
      this.isUserLoggedIn=false;
    }
   
  }

}
