import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class AuthService 
{
    is_logged_in = "is_logged_in";
    True = "true";
    False = "false"; 

    constructor(private route: Router)
    {
    }

    login(): void
    {
      console.log("login fired");
      localStorage.setItem(this.is_logged_in, this.True);
      this.route.navigate(["home"]);
    }
  
    logout(): void
    {
      console.log("logout fired");
      localStorage.setItem(this.is_logged_in, this.False);
    }
  
    authenticate(): boolean
    {
        if( localStorage.getItem(this.is_logged_in) == this.True)
        {
            return true;
        }
        
        return false;
    }
}
