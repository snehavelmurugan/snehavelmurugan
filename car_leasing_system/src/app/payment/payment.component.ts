import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
declare var Razorpay: any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent {
  constructor(private ar: ActivatedRoute) {
    
   this.paymentAmount = this.ar.snapshot.params["price"];
    
    
  }
  paymentAmount: number = 0;
  initiatePayment() {

    if (this.paymentAmount <= 0) {

      alert('Please enter a valid payment amount.');

      return;

    }
    const options = {

      // key: 'rzp_test_xBOtkpjwixHABA',

      key: 'rzp_test_PSIn2sFjfBg0uQ',
      amount: this.paymentAmount * 100,
      currency: 'INR',
      name: 'Car Leasing System',
      description: 'Product Purchase',
      image: '/assets/images/33115.jpg',
      handler: (response: any) => {
        console.log(response);

        alert('Payment successful!');

      },

    };
    const rzp = new Razorpay(options);

    rzp.open();

  }

}
