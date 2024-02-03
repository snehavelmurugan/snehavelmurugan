import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackComponent } from './feedback.component';

import { FeedbackService } from 'src/app/services/feedback.service';

import { of } from 'rxjs';

import { Feedback } from 'src/app/model/feedback.model';



describe('FeedbackComponent', () => {

  let component: FeedbackComponent;

  let fixture: ComponentFixture<FeedbackComponent>;

  let feedbackService: FeedbackService;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [FeedbackComponent],

      providers: [FeedbackService],

    }).compileComponents();



    fixture = TestBed.createComponent(FeedbackComponent);

    component = fixture.componentInstance;

    feedbackService = TestBed.inject(FeedbackService);



    fixture.detectChanges();

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should load feedback on initialization', () => {

    const feedbackList: Feedback[] = [

      { id: 1, carModel: 'Model A', feedbackText: 'Feedback 1', starRating: 5 },

      { id: 2, carModel: 'Model B', feedbackText: 'Feedback 2', starRating: 4 },

    ];



    spyOn(feedbackService, 'getAllFeedback').and.returnValue(of(feedbackList));

    component.ngOnInit();



    expect(feedbackService.getAllFeedback).toHaveBeenCalled();

    expect(component.feedbackList).toEqual(feedbackList);

  });



  it('should select feedback', () => {

    const selectedFeedback: Feedback = { id: 1, carModel: 'Model A', feedbackText: 'Selected Feedback', starRating: 3 };

    component.selectFeedback(selectedFeedback);



    expect(component.selectedFeedback).toEqual(selectedFeedback);

  });



  it('should clear selected feedback', () => {

    component.selectedFeedback = null;

    component.clearSelectedFeedback();



    expect(component.selectedFeedback).toBeNull();

  });



  it('should create new feedback', () => {

    const newFeedback: Feedback = { id: 3, carModel: 'Model C', feedbackText: 'New Feedback', starRating: 4 };



    spyOn(feedbackService, 'createFeedback').and.returnValue(of(newFeedback));

    spyOn(feedbackService, 'getAllFeedback').and.returnValue(of([...component.feedbackList, newFeedback]));



    component.newFeedback = newFeedback;

    component.createNewFeedback();



    expect(feedbackService.createFeedback).toHaveBeenCalledWith(newFeedback);

    expect(component.newFeedback).toEqual({ id: 0, carModel: '', feedbackText: '', starRating: 0 });

    expect(feedbackService.getAllFeedback).toHaveBeenCalled();

  });



  it('should update selected feedback', () => {

    const selectedFeedback: Feedback = { id: 1, carModel: 'Model A', feedbackText: 'Selected Feedback', starRating: 3 };



    spyOn(feedbackService, 'updateFeedback').and.returnValue(of(selectedFeedback));

    spyOn(feedbackService, 'getAllFeedback').and.returnValue(of([...component.feedbackList]));



    component.selectedFeedback = selectedFeedback;

    component.updateSelectedFeedback();



    expect(feedbackService.updateFeedback).toHaveBeenCalledWith(selectedFeedback.id, selectedFeedback);

    expect(component.selectedFeedback).toBeNull();

    expect(feedbackService.getAllFeedback).toHaveBeenCalled();

  });



  it('should delete selected feedback', () => {

    const selectedFeedback: Feedback = { id: 1, carModel: 'Model A', feedbackText: 'Selected Feedback', starRating: 3 };



    spyOn(feedbackService, 'deleteFeedback').and.returnValue(of(void 0));

    spyOn(feedbackService, 'getAllFeedback').and.returnValue(of([]));



    component.selectedFeedback = selectedFeedback;

    component.deleteSelectedFeedback();



    expect(feedbackService.deleteFeedback).toHaveBeenCalledWith(selectedFeedback.id);

    expect(component.selectedFeedback).toBeNull();

    expect(feedbackService.getAllFeedback).toHaveBeenCalled();

  });

});