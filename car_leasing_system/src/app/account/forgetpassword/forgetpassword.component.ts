import { Component } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { EmailService } from 'src/app/services/email.service';

@Component({
  selector: 'app-forgetpassword',
  templateUrl: './forgetpassword.component.html',
  styleUrls: ['./forgetpassword.component.scss']
})
export class ForgetpasswordComponent
{
    constructor(public modalRef: MdbModalRef<ForgetpasswordComponent>, private mail_service: EmailService) {}

    email: string = "";

    send_mail()
    {
        console.log("send mail function fired");

        this.mail_service.send_mail(this.email).subscribe((response) => {
            window.alert(response);
        })
    }
}
