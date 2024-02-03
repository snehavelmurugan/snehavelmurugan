
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})

export class ReservationComponent implements OnInit {
  selectedLocation: any;
  startDate!: Date;
  endDate!: Date;

  availableLocations: string[] = ['Ariyalur',
    'Chennai',
    'Coimbatore',
    'Cuddalore',
    'Dharmapuri',
    'Dindigul',
    'Erode',
    'Kanchipuram',
    'Kanyakumari',
    'Karur',
    'Krishnagiri',
    'Madurai',
    'Nagapattinam',
    'Namakkal',
    'Nilgiris',
    'Perambalur',
    'Pudukkottai',
    'Ramanathapuram',
    'Salem',
    'Sivaganga',
    'Tenkasi',
    'Thanjavur',
    'Theni',
    'Thoothukudi',
    'Tiruchirappalli',
    'Tirunelveli',
    'Tirupathur',
    'Tiruppur',
    'Tiruvallur',
    'Tiruvannamalai',
    'Tiruvarur',
    'Vellore',
    'Viluppuram',
    'Virudhunagar'];
  price: any;

  constructor(private route: Router, private ar: ActivatedRoute) {
  }
  ngOnInit(): void {
    this.price = this.ar.snapshot.params["lease_price"];
    console.log(this.ar.snapshot.params["lease_price"]);
  }
  submitReservation(): void {
    if (this.selectedLocation && this.startDate && this.endDate) {
      this.route.navigate(["payment",this.price]);

      console.log('Reservation submitted:', this.selectedLocation, this.startDate, this.endDate);
    } else {
      alert('Please fill in all fields before submitting.');
    }
  }
}


