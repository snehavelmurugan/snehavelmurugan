package com.carleasingsystem.api.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carleasingsystem.api.Entities.Feedback;
import com.carleasingsystem.api.Exception.ResourceNotFoundException;
import com.carleasingsystem.api.Repositories.FeedbackRepository;




@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + id));
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        Feedback existingFeedback = getFeedbackById(id);
        existingFeedback.setCarModel(updatedFeedback.getCarModel());
        existingFeedback.setFeedbackText(updatedFeedback.getFeedbackText());
        existingFeedback.setStarRating(updatedFeedback.getStarRating());
        return feedbackRepository.save(existingFeedback);
    }

    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        feedbackRepository.delete(feedback);
    }
}

