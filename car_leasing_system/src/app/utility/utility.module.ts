import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorComponent } from './error/error.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';


@NgModule({
  declarations: [
    ErrorComponent,
    AboutComponent,
    ContactComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    AboutComponent,
    ContactComponent
  ]
})
export class UtilityModule { }
