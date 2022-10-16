import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service :HttpServiceService) { }

  ngOnInit(): void {
  }
  _tmpIntroHeadline: string = 'Welcome to Consumer Loan Application';
  _tmpIntroDesc: string = 'Please fill four steps to apply for consumer loan. In the end will see all summary of loan information.';
  _tmpIntroFooter = 'Thank you.'

}
