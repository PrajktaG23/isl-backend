package com.platform.isl_backend.Repository;

import com.platform.isl_backend.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
