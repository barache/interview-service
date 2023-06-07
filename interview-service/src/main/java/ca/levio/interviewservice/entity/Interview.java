package ca.levio.interviewservice.entity;

import ca.levio.interviewservice.utils.LevelOfExpertise;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interview {
  @Id
  @Column(name = "interview_id", nullable = false, updatable = false)
  private String id;
  private String recruiter;
  private String email;
  private String applicant;
  private String levelOfExpertise;
  private String description;
  private boolean urgency;

  @OneToOne
  @JoinColumn(name = "job_position", referencedColumnName = "jobPosition")
  private JobPosition jobPosition;

}
