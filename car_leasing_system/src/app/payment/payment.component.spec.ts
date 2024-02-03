import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentComponent } from './payment.component';



describe('PaymentComponent', () => {

  let component: PaymentComponent;

  let fixture: ComponentFixture<PaymentComponent>;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [PaymentComponent],

    }).compileComponents();



    fixture = TestBed.createComponent(PaymentComponent);

    component = fixture.componentInstance;



    // Create a spy on the alert method

    spyOn(window, 'alert');

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should initiate payment with a valid amount', () => {

    component.paymentAmount = 500; // Set a valid payment amount



    component.initiatePayment();



    // Check that the window.alert method was not called

    expect(window.alert).not.toHaveBeenCalled();

  });



  it('should handle initiating payment with an invalid amount', () => {

    component.paymentAmount = 0; // Set an invalid payment amount



    component.initiatePayment();



    // Check that window.alert was called with the error message

    expect(window.alert).toHaveBeenCalledWith('Please enter a valid payment amount.');

  });



  // Add more test cases for handling the Razorpay payment initiation



  // Cleanup after testing

  afterEach(() => {

    TestBed.resetTestingModule();

  });

});