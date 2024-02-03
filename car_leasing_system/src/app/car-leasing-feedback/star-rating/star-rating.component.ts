import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.scss']
})
export class StarRatingComponent {
  @Input() rating: number = 0; // Input property to receive the rating value
  @Output() ratingChange: EventEmitter<number> = new EventEmitter<number>();

  // Define the maximum number of stars (adjust as needed)
  maxStars: number = 5;

  // Create an array to represent stars
  stars: number[] = [];

  constructor() {
    // Initialize the stars array with values from 1 to maxStars
    for (let i = 1; i <= this.maxStars; i++) {
      this.stars.push(i);
    }
  }

  // Function to set the rating when a star is clicked
  setRating(rating: number) {
    this.rating = rating;
    this.ratingChange.emit(this.rating);
  }
}



