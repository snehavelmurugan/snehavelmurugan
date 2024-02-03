// feedback.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feedback } from '../model/feedback.model';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private baseUrl = 'http://localhost:9002/api/feedback'; // Replace with your Spring Boot API URL

  constructor(private http: HttpClient) {}

  getAllFeedback(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.baseUrl}`);
  }

  getFeedbackById(id: number): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.baseUrl}/${id}`);
  }

  createFeedback(feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(`${this.baseUrl}`, feedback);
  }

  updateFeedback(id: number, updatedFeedback: Feedback): Observable<Feedback> {
    return this.http.put<Feedback>(`${this.baseUrl}/${id}`, updatedFeedback);
  }

  deleteFeedback(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}

