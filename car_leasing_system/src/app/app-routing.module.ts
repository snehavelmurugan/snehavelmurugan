import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './account/login/login.component';
import { VehicleAddComponent } from './crud/vehicleadd/vehicleadd.component';
import { VehicleupdateComponent } from './crud/vehicleupdate/vehicleupdate.component';
import { VechicleviewComponent } from './crud/vehicleview/vehicleview.component';
import { HomeComponent } from './home/home.component';
import { ReservationComponent } from './reservation/reservation/reservation.component';
import { PaymentComponent } from './payment/payment.component';
import { LeaseAgreementFormComponent } from './fileexp/lease-agreement-form/lease-agreement-form.component';
import { DocumentationComponent } from './exp/documentation/documentation.component';
import { DownloadComponent } from './exp/download/download.component';
import { EntityComponent } from './exp/entity/entity.component';
import { FeedbackComponent } from './car-leasing-feedback/feedback/feedback.component';
import { AboutComponent } from './utility/about/about.component';
import { ContactComponent } from './utility/contact/contact.component';

const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: "home",
        component: HomeComponent
    },
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "view",
        component: VechicleviewComponent
    },
    {
        path: "add",
        component: VehicleAddComponent
    },
    {
        path: "vehicle-update/:id",
        component: VehicleupdateComponent
    },
    {
        path: "reservation/:lease_price",
        component: ReservationComponent
    },
    {
        path: "lease-agreement",
        component: LeaseAgreementFormComponent
    },
    {
        path: "payment/:price",
        component: PaymentComponent
    },
    {
        path: "feedback",
        component: FeedbackComponent
    },
    {
        path: "about",
        component: AboutComponent
    },
    {
        path: "contact",
        component: ContactComponent
    },
    {
        path: "document",
        component: EntityComponent
    },
    {
        path: "download",
        component : DownloadComponent
    },
    {
        path: "**",
        component: PaymentComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
