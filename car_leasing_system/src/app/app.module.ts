import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AccountModule } from './account/account.module';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { RouterModule, Routes } from '@angular/router';
import { CrudModule } from './crud/crud.module';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReservationComponent } from './reservation/reservation/reservation.component';
import { ReservationModule } from './reservation/reservation.module';
import { LeaseAgreementFormComponent } from './fileexp/lease-agreement-form/lease-agreement-form.component';
import { PaymentComponent } from './payment/payment.component';
import { DocumentationComponent } from './exp/documentation/documentation.component';
import { DownloadComponent } from './exp/download/download.component';
import { EntityComponent } from './exp/entity/entity.component';
import { FeedbackComponent } from './car-leasing-feedback/feedback/feedback.component';
import { StarRatingComponent } from './car-leasing-feedback/star-rating/star-rating.component';


const routes: Routes = [

];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LeaseAgreementFormComponent,
    PaymentComponent,
    DocumentationComponent,
    DownloadComponent,
    EntityComponent,
    FeedbackComponent,
    StarRatingComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AccountModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule,
    RouterModule.forRoot(routes),
    RouterModule,
    HttpClientModule,
    CrudModule,
    FormsModule,
    ReservationModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }



