import { Component } from '@angular/core';
import { LeaseAgreementService } from '../lease-agreement.service';

@Component({
  selector: 'app-lease-agreement-form',
  templateUrl: './lease-agreement-form.component.html',
  styleUrls: ['./lease-agreement-form.component.scss']
})
export class LeaseAgreementFormComponent {
  formData: any = {
    customerId: '',
    startDate: '',
    endDate: '',
    payment: 0
  };

  constructor(private leaseAgreementService: LeaseAgreementService) { }

  generateLeaseAgreement() {
    this.leaseAgreementService.generateLeaseAgreement(this.formData)
      .subscribe((response: Blob) => {
        // Handle the PDF response here, e.g., display it or save it
        const blob = new Blob([response], { type: 'application/pdf' });
        const url = window.URL.createObjectURL(blob);
        window.open(url);
      }, (error: any) => {
        console.error('Error generating lease agreement:', error);
      });
  }
}


