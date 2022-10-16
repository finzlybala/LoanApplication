import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-loan-booking',
  templateUrl: './loan-booking.component.html',
  styleUrls: ['./loan-booking.component.css']
})
export class LoanBookingComponent implements OnInit {
  currentDate =new Date();

  loanStartingDate:any[]=[
    0,1,2,3,4,5,6,7,8,9,10
      ];
      
  paymentStartingfrequency:any[]=[
    1,3,6,12
  ];
  paymentterm:any[]=[
    "Intrest Only","Even Principal"
    
  ];
  paymentendingfrequency:any[]=[
    6,12,18,24,36,48,60
  ]


 
  constructor(private service:HttpServiceService,private router:Router) { 

              this.maxDate.setDate(this.maxDate.getDate()+7);
             }
maxDate=new Date();
  ngOnInit():void {
  }
  onSubmit(f:NgForm){
    let obj={ 
    loanAmount: f.value. LoanAmount,
    loanStartDate:f.value.loanStartDate,
    paymentFrequency:f.value.paymentfrequency,
    paymentTerm:f.value.paymentterms,
    maturityDate:f.value.maturitydate,
    intrestRate:f.value.intrestrate
  }
  console.log(obj);
  this.service.loanbooking(obj).subscribe((response=>{
    console.log(response);
  }))
  alert('Your response was submitted successfully.....!');
  this.router.navigate(['/home']);

}
onCancel(){
  alert("Your last process was cancelled");
  this.router.navigate(['/home']);
}

}