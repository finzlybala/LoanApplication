import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoanBookingComponent } from './loan-booking/loan-booking.component';
import { LoanDetialsComponent } from './loan-detials/loan-detials.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PaymentScheduleComponent } from './payment-schedule/payment-schedule.component';

const routes: Routes = [
  {
    path:"",redirectTo:"/home",pathMatch:"full"
  },

  {
    path:"home",component:HomeComponent
  },

  {
    path:"createloan",component:LoanBookingComponent
  },

  {
    path:"displayloans",component:LoanDetialsComponent
  },
  {
    path:"displayPaymentSchedule/:id",component:PaymentScheduleComponent
  },
   {
     path:"**",component:PageNotFoundComponent
   }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
