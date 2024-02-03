import { Component, ElementRef, HostListener, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from 'src/app/model/vehicle';
import { DartService } from 'src/app/services/dart.service';

@Component({
  selector: 'app-vehicleupdate',
  templateUrl: './vehicleupdate.component.html',
  styleUrls: ['./vehicleupdate.component.scss']
})
export class VehicleupdateComponent implements OnInit {
  raw_data: any;
  id!: number;
  selectedFile: any;
  onFileSelected(event: any): void {
    const inputElement = event.target as HTMLInputElement;
    const file = (inputElement.files as FileList).item(0);

    if (file) {
      this.selectedFile = file;
    }
  }


  data: Vehicle = new Vehicle();
  vehicleForm = new FormGroup(
    {
      vin: new FormControl(0),
      made: new FormControl(""),
      model: new FormControl(""),
      year: new FormControl(0),
      lease_price: new FormControl(0),
      image: new FormControl(null)

    }
  )
  imageSrc: string = '';

  constructor(private reg: DartService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder, private host: ElementRef<HTMLInputElement>) {

    // this.reg.getdataById(this.data.vin).subscribe((data)=>{
    //   console.log(data);
    // })

  }

  ngOnInit(): void {
    this.data = new Vehicle();
    this.vehicleForm = this.formBuilder.group(
      {
        vin: [0, [Validators.required]],
        made: ["", [Validators.required]],
        model: ["", [Validators.required]],
        year: [0, [Validators.required]],
        lease_price: [0, [Validators.required]],
        image: [null, [Validators.required]],
       

      }
    );
    // this.imageSrc = `/images/${this.data.vin}`;
    this.id = this.route.snapshot.params['id'];

    this.reg.getdataById(this.id).subscribe((d) => {
      this.data = d;
      this.vehicleForm.value.vin = d.vin;
      this.vehicleForm.value.made = d.made as string;
      this.vehicleForm.value.model = d.model as string;
      this.vehicleForm.value.year = d.year;
      this.vehicleForm.value.lease_price = d.lease_price;
      console.log(this.vehicleForm.value);
    })
  }
  getByIds(id: number) {

  }
  updateVehicle() {
    
    const updatedData = this.vehicleForm.value;
    console.log(updatedData);
    this.reg.updateVehicle(this.vehicleForm.value.vin as number, updatedData).subscribe(
      () => {
        // Handle the success response here
        alert('Vehicle updated successfully');
      },
      (error: any) => {
        // Handle the error response here
        alert('Vehicle update error: ' + JSON.stringify(error));
      }
    );
  }

  deleteVehicle() {
    const vehicleIdToDelete = this.data.vin; // Replace with the ID of the vehicle you want to delete

    this.reg.deletedata(vehicleIdToDelete).subscribe(
      (response) => {
        // Handle success, e.g., show a success message
        console.log('Vehicle deleted successfully', response);
        this.router.navigate(['view']);
      },
      (error) => {
        // Handle error, e.g., show an error message
        console.error('Error deleting vehicle', error);
      }
    );
  }
  submiForm() {
    console.log("Submitted Form");
  }
  onChange!: Function;
  private file: File | null = null;

  @HostListener('change', ['$event.target.files']) emitFiles(event: FileList) {
    const file = event && event.item(0);
    this.onChange(file);
    this.file = file;
  }

  writeValue(value: null) {
    // clear file input
    this.host.nativeElement.value = '';
    this.file = null;
  }

  registerOnChange(fn: Function) {
    this.onChange = fn;
  }

  registerOnTouched(fn: Function) {
  }

}

