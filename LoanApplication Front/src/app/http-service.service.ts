import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  paySchedule() {
    throw new Error('Method not implemented.');
  }
  datas() {
    throw new Error('Method not implemented.');
  }
  loan() {
    throw new Error('Method not implemented.');
  }
 
  constructor(private http:HttpClient) { }

  loanbooking(obj:any){
    return this.http.post(`${environment.BaseUrl}create`,obj,{
      responseType:"text"
    });
  }


  loanSchedule(){
    return (this.http.get(`${environment.BaseUrl}print`));

  }
  paymentSchedule(id:number){
    return(this.http.get(`${environment.BaseUrl}customer/${id}`))
  }
  paymentStatus(paymentId:number){
    return(this.http.put(`${environment.BaseUrl}customer/payment/${paymentId}`,null,{
      responseType:"text"
    }));
  }
}
