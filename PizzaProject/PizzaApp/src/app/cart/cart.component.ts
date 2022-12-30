import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';
import { PizzaCrudOpService } from '../service/pizza-crud-op.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private crud:PizzaCrudOpService, private login:LoginService,private route:Router) { }

  recData:any
  num:number=0
  total:number=0;

  ngOnInit(): void {
    this.crud.getOrder(this.login.user.userId).subscribe(data=>{
        this.recData=data;
        console.log(data);
        this.num=this.recData.foodProducts.length
        for(let i=0;i<this.recData.foodProducts.length;i++){
          this.total=this.total+this.recData.foodProducts[i].price;
        }
    })
  }

  orderNow(){
    var i= this.recData.foodProducts.length;
    var j=0;
    
    while(i!=0){
      for(j=0;j<i;j++){
      this.crud.removeVal(this.recData.foodProducts[j].foodName,this.login.user.userId).subscribe(data=>console.log(data));
      }
      i--;
    }

    alert("Ordered sucessfully");
    this.route.navigateByUrl("/");
  }

}
