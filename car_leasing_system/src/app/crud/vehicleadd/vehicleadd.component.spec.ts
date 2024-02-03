import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleAddComponent } from './vehicleadd.component';

import { FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';

import { DartService } from 'src/app/services/dart.service';

import { of } from 'rxjs';



describe('VehicleAddComponent', () => {

  let component: VehicleAddComponent;

  let fixture: ComponentFixture<VehicleAddComponent>;

  let dartService: DartService;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [VehicleAddComponent],

      providers: [FormBuilder, DartService],

      imports: [ReactiveFormsModule, FormsModule],

    }).compileComponents();



    fixture = TestBed.createComponent(VehicleAddComponent);

    component = fixture.componentInstance;

    dartService = TestBed.inject(DartService);

    fixture.detectChanges();

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should initialize the form with the required controls', () => {

    expect(component.vehicleForm.get('vehicle.made')).toBeTruthy();

    expect(component.vehicleForm.get('vehicle.model')).toBeTruthy();

    expect(component.vehicleForm.get('vehicle.year')).toBeTruthy();

    expect(component.vehicleForm.get('vehicle.lease_price')).toBeTruthy();

    expect(component.vehicleForm.get('file')).toBeTruthy();

  });



  it('should set selectedFile on file selection', () => {

    const file = new File([''], 'test.png', { type: 'image/png' });

    const event = {

      target: {

        files: [file],

      },

    };



    component.onFileSelected(event);

    expect(component.selectedFile).toEqual(file);

  });



  it('should submit the form', () => {

    const formData = new FormData();

    formData.append('made', 'Toyota');

    formData.append('model', 'Camry');

    formData.append('year', '2022');

    formData.append('lease_price', '300.50');



    spyOn(dartService, 'submitForm').and.returnValue(of({}));



    component.vehicleForm.patchValue({

      vehicle: {

        made: 'Toyota',

        model: 'Camry',

        year: '2022',

        lease_price: '300.50',

      },

    });



    component.selectedFile = new File([''], 'test.png', { type: 'image/png' });



    component.onSubmit();



    expect(dartService.submitForm).toHaveBeenCalledWith(formData);

    // You can also add more expectations here based on your specific requirements.

  });

});