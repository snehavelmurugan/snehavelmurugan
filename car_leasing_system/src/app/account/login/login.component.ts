import { Component, OnInit } from '@angular/core';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { ForgetpasswordComponent } from '../forgetpassword/forgetpassword.component';
import { AuthService } from 'src/app/services/auth.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import { User } from 'src/app/entities/user';
import { Credentials } from 'src/app/entities/credentials';
import { AbstractControl, ValidatorFn } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit
{
    modalRef: MdbModalRef<ForgetpasswordComponent> | null = null;

    registerform = new FormGroup(
        {
            name: new FormControl(""),
            username: new FormControl(""),
            email: new FormControl(""),
            password: new FormControl(""),
            confirm_password: new FormControl(""),
            terms: new FormControl(false)
        }
    );
    
    loginform = new FormGroup(
        {
            login_value: new FormControl(""),
            login_password: new FormControl(""),
            remember_me: new FormControl(false)
        }
    );

    constructor(
        private modalService: MdbModalService,
        private apiservice: ApiService,
        private formBuilder: FormBuilder,
        private authservice: AuthService)
    {
    }

    ngOnInit(): void 
    {
        this.loginform = this.formBuilder.group(
            {
                login_value: ["", Validators.required],
                login_password: ["", Validators.required],
                remember_me: [false, Validators.required]
            }
        );

        this.registerform = this.formBuilder.group(
            {
                name: ["", Validators.required],
                username: ["", Validators.required],
                email: ["", [Validators.required, Validators.email]],
                password: ["", [Validators.required, Validators.pattern("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{4,10}")]],
                confirm_password: ["", Validators.required],
                terms: [false, Validators.requiredTrue]
            },
            {
                validators: [Validation.match("password", "confirm_password")]
            }
        );
    }

    login_submitted = false;
    register_submitted = false;

    get rf(): { [key: string]: AbstractControl } {
        console.log(this.registerform.controls);
        return this.registerform.controls;
      }

    get lf(): { [key: string]: AbstractControl } {
        console.log(this.loginform.controls);
        return this.loginform.controls;
      }

    openModal() {
      this.modalRef = this.modalService.open(ForgetpasswordComponent, {
        modalClass: 'modal-dialog-centered'
      })
    }

    register()
    {
        this.register_submitted = true;

        if(this.registerform.invalid)
        {
            console.log(this.registerform.controls);
            console.log("form invalid");
            window.alert("fill the requirements");
            return;
        }


        let user: User = new User();

        let form_data: any = this.registerform.value;

        if(form_data.password == form_data.confirm_password)
        {
            user.name = form_data.name;
            user.username = form_data.username;
            user.email = form_data.email;
            user.password = form_data.password;
    
            this.apiservice.registerUser(user).subscribe((response: any) => {
                console.log(response);

                window.alert(response.t);
            });
        }
        else
        {
            window.alert("password not match");
        }
    }

    login()
    {
        this.login_submitted = true;

        if(this.loginform.invalid)
        {
            console.log(this.loginform.controls);
            console.log("from invalid");
            window.alert("fill the requriements");
            return;
        }

        
        let credential: Credentials = new Credentials();
        
        credential.username = this.loginform.value.login_value as string;
        credential.password = this.loginform.value.login_password as string;
        
        this.apiservice.loginUser(credential).subscribe((response: any) => {
            console.log(response);

            if(response.status_code == 0)
            {
                this.authservice.login();
                console.log("logged in");
            }
            else
            {
                window.alert(response.t);
            }
        })
    }

    revert_login()
    {
        this.login_submitted = false;
        this.loginform.reset();
    }

    revert_register()
    {
        this.register_submitted = false;
        this.registerform.reset();
    }
}

export default class Validation {
  static match(controlName: string, checkControlName: string): ValidatorFn {
    return (controls: AbstractControl) => {
      const control = controls.get(controlName);
      const checkControl = controls.get(checkControlName);

      if (checkControl?.errors && !checkControl.errors['matching']) {
        return null;
      }

      if (control?.value !== checkControl?.value) {
        controls.get(checkControlName)?.setErrors({ matching: true });
        return { matching: true };
      } else {
        return null;
      }
    };
  }
}