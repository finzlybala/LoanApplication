import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-payment-schedule',
  templateUrl: './payment-schedule.component.html',
  styleUrls: ['./payment-schedule.component.css']
})
export class PaymentScheduleComponent implements OnInit {
  datas:any[]=[];
  p:number=1;
  constructor(private service:HttpServiceService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
   this.paySch();
  }

  paySch(){
    this.route.paramMap.subscribe((param:any)=>{
      this.service.paymentSchedule(param.get("id"))
      .subscribe((response:any)=>{
        console.log(response);
        this.datas=response;
      })
    })
  
  }
  onClick(){
    this.router.navigate(['displayloans']);
  }

  onConfirm(paymentId:any){
    this.service.paymentStatus(paymentId)
    .subscribe((res)=>{
      if(confirm("Do you want to Pay")){
        alert("Payment success ");
        location.reload();
      }
      else{
        alert("Payment Cancel")
      }
    })
    
  }

}
