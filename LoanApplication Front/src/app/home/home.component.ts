import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service :HttpServiceService,
    private router:Router) { }

  ngOnInit(): void {
  }
  onApplyLoan(){
    this.router.navigate(['/createloan']);
  }
  onLoanDetials(){
    this.router.navigate(['/displayloans']);
  }
}
