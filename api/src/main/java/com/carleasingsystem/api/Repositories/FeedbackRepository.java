package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carleasingsystem.api.Entities.Feedback;




public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
