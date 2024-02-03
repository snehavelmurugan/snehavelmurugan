import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DartService } from 'src/app/services/dart.service';

@Component({
  selector: 'app-vehicleadd',
  templateUrl: './vehicleadd.component.html',
  styleUrls: ['./vehicleadd.component.scss']
})
export class VehicleAddComponent {
  selectedFile: File | null = null;

  onFileSelected(event: any): void {
    const inputElement = event.target as HTMLInputElement;
    const file = (inputElement.files as FileList).item(0);

    if (file) {
      this.selectedFile = file;
    }
  }

  vehicleForm: FormGroup;

  constructor(private fb: FormBuilder, private reg: DartService) {
    this.vehicleForm = this.fb.group({
      vehicle: this.fb.group({
        made: ['', Validators.required],
        model: ['', Validators.required],
        year: ['', [Validators.required, Validators.pattern(/^\d{4}$/)]],
        lease_price: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/)]],
      }),
      file: [null, Validators.required]
    });
  }

  onSubmit() {
    const data = new FormData();
    data.append('made', this.vehicleForm.get('vehicle.made')?.value);
    data.append('model', this.vehicleForm.get('vehicle.model')?.value);
    data.append('year', this.vehicleForm.get('vehicle.year')?.value);
    data.append('lease_price', this.vehicleForm.get('vehicle.lease_price')?.value);
    if (this.selectedFile) {
      data.append('file', this.selectedFile);
    }

    this.reg.submitForm(data).subscribe(
      (response) => {
        alert('Form Submitted Successfully');
      },
      (error) => {
        alert('Error submitting form');
      }
    );
  }
}
