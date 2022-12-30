import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PizzaCrudOpService {

  food:{foodName:string,price:string}[]=[
    {
    foodName:"Cheese Oniom Pizza",
    price:"400"
  },
  {
    foodName:"Double Cheese Pizza",
    price:"350"
  },
  {
    foodName:"Margherita Pizza",
    price:"700"
  },{
    foodName:"Peri Peri Pizza",
    price:"650"
  },
  {
    foodName:"Cheese Corn Pizza",
    price:"499"
  },
  {
    foodName:"Tandoori Pizza",
    price:"699"
  }]

  constructor(private http:HttpClient) { }

  addOrder(value:any,id:string):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.post<any>('http://localhost:9000/api/v2/user/'+id,this.food[value],requestOptions)
  }

  removeOrder(value:any,id:string):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.delete<any>('http://localhost:9000/api/v2/user/'+this.food[value].foodName+'/'+id,requestOptions)
  }

  getOrder(id:string):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.get<any>('http://localhost:9000/api/v2/user/'+id,requestOptions)
  }
  removeVal(value:any,id:string):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.delete<any>('http://localhost:9000/api/v2/user/'+value+'/'+id,requestOptions)
  }
}
