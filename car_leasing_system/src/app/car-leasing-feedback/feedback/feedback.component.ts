import { Component } from '@angular/core';
import { Feedback } from 'src/app/model/feedback.model';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent {
  feedbackList: Feedback[] = [];
  selectedFeedback: Feedback | null = null;
  newFeedback: Feedback = new Feedback();

  constructor(private feedbackService: FeedbackService) { }

  ngOnInit() {
    this.loadFeedback();
  }

  loadFeedback() {
    this.feedbackService.getAllFeedback().subscribe((data: Feedback[]) => {
      this.feedbackList = data;
    });
  }

  selectFeedback(feedback: Feedback) {
    this.selectedFeedback = feedback;
  }

  clearSelectedFeedback() {
    this.selectedFeedback = null;
  }

  createNewFeedback() {
    this.feedbackService.createFeedback(this.newFeedback).subscribe(() => {
      this.newFeedback = new Feedback();
      this.loadFeedback();
    });
  }

  // feedback.component.ts

  updateSelectedFeedback() {
    if (this.selectedFeedback) {
      this.feedbackService.updateFeedback(this.selectedFeedback.id, this.selectedFeedback).subscribe(
        (updatedFeedback: any) => {
          // Handle successful update
          console.log('Feedback updated successfully', updatedFeedback);
          this.loadFeedback(); // Refresh the feedback list
          this.clearSelectedFeedback();
        },
        (error: any) => {
          // Handle error
          console.error('Error updating feedback', error);
        }
      );
    }
  }


  deleteSelectedFeedback() {
    if (this.selectedFeedback) {
      this.feedbackService.deleteFeedback(this.selectedFeedback.id).subscribe(() => {
        this.clearSelectedFeedback();
        this.loadFeedback();
      });
    }
  }
}

