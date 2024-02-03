import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeaseAgreementService {
  private baseUrl = 'http://localhost:9002/cls/leaseagreement'; // Replace with your backend URL

  constructor(private http: HttpClient) { }

  generateLeaseAgreement(formData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/generate`, formData, {
      responseType: 'blob' // Indicate that the response will be binary data (PDF)
    });
  }
}

