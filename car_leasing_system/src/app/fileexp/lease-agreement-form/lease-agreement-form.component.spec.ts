import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaseAgreementFormComponent } from './lease-agreement-form.component';

import { LeaseAgreementService } from '../lease-agreement.service';

import { of } from 'rxjs';



describe('LeaseAgreementFormComponent', () => {

  let component: LeaseAgreementFormComponent;

  let fixture: ComponentFixture<LeaseAgreementFormComponent>;

  let leaseAgreementService: LeaseAgreementService;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [LeaseAgreementFormComponent],

      providers: [LeaseAgreementService],

    }).compileComponents();



    fixture = TestBed.createComponent(LeaseAgreementFormComponent);

    component = fixture.componentInstance;

    leaseAgreementService = TestBed.inject(LeaseAgreementService);

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should generate a lease agreement', () => {

    const formData = {

      customerId: '123',

      startDate: '2023-10-16',

      endDate: '2023-11-16',

      payment: 500,

    };



    const pdfBlob = new Blob(['PDF Data'], { type: 'application/pdf' });

    spyOn(leaseAgreementService, 'generateLeaseAgreement').and.returnValue(of(pdfBlob));



    spyOn(window, 'open');



    component.formData = formData;

    component.generateLeaseAgreement();



    expect(leaseAgreementService.generateLeaseAgreement).toHaveBeenCalledWith(formData);

    expect(window.open).toHaveBeenCalledWith(URL.createObjectURL(pdfBlob));

  });



  // Add more test cases for other component methods and error handling



  // Cleanup after testing

  afterEach(() => {

    TestBed.resetTestingModule();

  });

});