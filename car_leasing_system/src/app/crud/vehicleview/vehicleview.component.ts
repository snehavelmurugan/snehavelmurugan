import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DartService } from 'src/app/services/dart.service';

@Component({
  selector: 'app-vehicleview',
  templateUrl: './vehicleview.component.html',
  styleUrls: ['./vehicleview.component.scss']
})
export class VechicleviewComponent {
  @Input() imageBytes: any;
  data: any;


  constructor(private view: DartService, private router: Router) {
    this.view.getdata().subscribe((data) => {
      this.data = data;
      console.log(data);
    });
  }


  updateVehicle(id: number) {
    this.router.navigate(['vehicle-update', id])

  }

  gotodoc() {
    this.router.navigate(["document"]);
  }
  book(lease_price : number) {
    this.router.navigate(["reservation",lease_price])
  }


}