import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-loan-detials',
  templateUrl: './loan-detials.component.html',
  styleUrls: ['./loan-detials.component.css']
})
export class LoanDetialsComponent implements OnInit {
  datas:any[]=[];
  p:number=1;
  constructor(private service :HttpServiceService,
              private router:Router) { }

  ngOnInit(): void {
    this.loanSch();
  }

  detials(){
  }

  loanSch(){
    this.service.loanSchedule()
    .subscribe((response:any)=>{
      this.datas=response;
    })
  }
  onClick(){
    this.router.navigate(['home']);
  } 
  
  
}
