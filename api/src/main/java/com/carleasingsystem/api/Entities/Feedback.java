package com.carleasingsystem.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carModel;
    private String feedbackText;
    private int starRating;
	
    public Feedback(Long id, String carModel, String feedbackText, int starRating) {
		super();
		this.id = id;
		this.carModel = carModel;
		this.feedbackText = feedbackText;
		this.starRating = starRating;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", carModel=" + carModel + ", feedbackText=" + feedbackText + ", starRating="
				+ starRating + "]";
	}
    
    


    
}
