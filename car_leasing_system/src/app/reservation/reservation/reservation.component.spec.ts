import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationComponent } from './reservation.component';



describe('ReservationComponent', () => {

  let component: ReservationComponent;

  let fixture: ComponentFixture<ReservationComponent>;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [ReservationComponent],

    }).compileComponents();



    fixture = TestBed.createComponent(ReservationComponent);

    component = fixture.componentInstance;



    // Create a spy on the alert method

    spyOn(window, 'alert');

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should submit a reservation with valid data', () => {

    component.selectedLocation = 'Chennai';

    component.startDate = new Date('2023-10-01');

    component.endDate = new Date('2023-10-10');



    component.submitReservation();



    // Check that the window.alert method was not called

    expect(window.alert).not.toHaveBeenCalled();

    // Check that the reservation was logged

    expect(console.log).toHaveBeenCalledWith('Reservation submitted:', 'Chennai', new Date('2023-10-01'), new Date('2023-10-10'));

  });



  it('should handle submitting a reservation with missing data', () => {

    component.submitReservation();



    // Check that the window.alert method was called with the error message

    expect(window.alert).toHaveBeenCalledWith('Please fill in all fields before submitting.');

  });



  // Add more test cases for different scenarios



  // Cleanup after testing

  afterEach(() => {

    TestBed.resetTestingModule();

  });

});



