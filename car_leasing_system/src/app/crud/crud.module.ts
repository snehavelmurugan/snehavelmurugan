import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehicleAddComponent } from './vehicleadd/vehicleadd.component';
import { VechicleviewComponent } from './vehicleview/vehicleview.component';
import { VehicleupdateComponent } from './vehicleupdate/vehicleupdate.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    VechicleviewComponent,
    VehicleAddComponent,
    VehicleupdateComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports: [
    VechicleviewComponent,
    VehicleAddComponent,
    VehicleupdateComponent
  ]
})
export class CrudModule { }
