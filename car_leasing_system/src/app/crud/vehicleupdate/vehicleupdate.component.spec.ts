import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveFormsModule } from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';

import { of } from 'rxjs';

import { VehicleupdateComponent } from './vehicleupdate.component';

import { DartService } from 'src/app/services/dart.service';



describe('VehicleupdateComponent', () => {

  let component: VehicleupdateComponent;

  let fixture: ComponentFixture<VehicleupdateComponent>;

  let dartService: DartService;

  let router: Router;

  let activatedRoute: ActivatedRoute;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [VehicleupdateComponent],

      providers: [DartService, Router, ActivatedRoute],

      imports: [ReactiveFormsModule],

    }).compileComponents();



    fixture = TestBed.createComponent(VehicleupdateComponent);

    component = fixture.componentInstance;

    dartService = TestBed.inject(DartService);

    router = TestBed.inject(Router);

    activatedRoute = TestBed.inject(ActivatedRoute);



    spyOn(window, 'alert');

    spyOn(console, 'error');

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should handle file selection', () => {

    const file = new File(['test file content'], 'test.jpg', { type: 'image/jpeg' });

    (component as any).emitFiles = jasmine.createSpy('emitFiles');

    (component as any).writeValue(null);

    (component as any).file = file;



    expect((component as any).emitFiles).toHaveBeenCalledWith(file);



    // Compare individual properties

    expect((component as any).file.name).toEqual(file.name);

    expect((component as any).file.type).toEqual(file.type);

    // Add more properties to compare if needed

  });



  it('should register and emit file changes', () => {

    const file = new File(['test file content'], 'test.jpg', { type: 'image/jpeg' });

    let emittedFile: File | null = null;

    component.registerOnChange((file: File | null) => {

      emittedFile = file;

    });



    component.onChange(file);

    expect(emittedFile).toEqual(file as any); // Cast file to 'any' to disable type checking

  });





  it('should update the vehicle', () => {

    const updatedData = {

      vin: 1,

      made: 'Updated Make',

      model: 'Updated Model',

      year: 2023,

      lease_price: 400.25,

      image: null,

    };



    component.vehicleForm.setValue(updatedData);

    spyOn(dartService, 'updateVehicle').and.returnValue(of({}));

    component.updateVehicle();



    expect(dartService.updateVehicle).toHaveBeenCalledWith(updatedData.vin, updatedData);

    expect(window.alert).toHaveBeenCalledWith('Vehicle updated successfully');

  });



  it('should delete the vehicle', () => {

    const vehicleIdToDelete = 1; // Replace with the ID of the vehicle you want to delete

    spyOn(dartService, 'deletedata').and.returnValue(of({}));

    spyOn(router, 'navigate');



    component.deleteVehicle();



    expect(dartService.deletedata).toHaveBeenCalledWith(vehicleIdToDelete);

    expect(router.navigate).toHaveBeenCalledWith(['view']);

  });

});