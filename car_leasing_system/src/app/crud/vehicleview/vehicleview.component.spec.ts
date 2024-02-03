import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Router } from '@angular/router';

import { of } from 'rxjs';

import { VechicleviewComponent } from './vehicleview.component';

import { DartService } from 'src/app/services/dart.service';



describe('VehicleviewComponent', () => {

  let component: VechicleviewComponent;

  let fixture: ComponentFixture<VechicleviewComponent>;

  let dartService: DartService;

  let router: Router;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [VechicleviewComponent],

      providers: [DartService, { provide: Router, useValue: { navigate: jasmine.createSpy('navigate') } }],

    }).compileComponents();



    fixture = TestBed.createComponent(VechicleviewComponent);

    component = fixture.componentInstance;

    dartService = TestBed.inject(DartService);

    router = TestBed.inject(Router);

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should navigate to vehicle update', () => {

    const id = 1; // Replace with the ID you want to test

    component.updateVehicle(id);

    expect(router.navigate).toHaveBeenCalledWith(['vehicle-update', id]);

  });



  it('should navigate to document', () => {

    component.gotodoc();

    expect(router.navigate).toHaveBeenCalledWith(['document']);

  });



  it('should fetch and set data from DartService', () => {

    const mockData = [{ /* Mock data object */ }];

    spyOn(dartService, 'getdata').and.returnValue(of(mockData));



    // component.ngOnInit();



    expect(dartService.getdata).toHaveBeenCalled();

    expect(component.data).toEqual(mockData);

  });

});


