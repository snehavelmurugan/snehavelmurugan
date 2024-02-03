import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailService 
{
    constructor(private httpClient: HttpClient) { }

    email_url = "http://localhost:9002/cls/auth/sendemail";

    send_mail(to: string)
    {
        return this.httpClient.post(this.email_url, to);
    }
}
