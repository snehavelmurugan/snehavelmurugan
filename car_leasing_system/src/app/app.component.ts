import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'car_leasing_system';

  constructor(private authservice:AuthService) 
  {
  }

  is_logged_in()
  {
    return this.authservice.authenticate();
  }

  logout()
  {
    this.authservice.logout();
  }
}

