package ca.levio.interviewservice.repository;

import ca.levio.interviewservice.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, String> {
}
