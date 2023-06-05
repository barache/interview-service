package ca.levio.interviewservice.entity;

import ca.levio.interviewservice.utils.LevelOfExpertise;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interview {
  @Id
  @Column(name = "interview_id", nullable = false)
  private String id;
  private String recruiter;
  private String email;
  private String applicant;
  @Enumerated(EnumType.STRING)
  private LevelOfExpertise levelOfExpertise;
  private String description;
  private boolean urgency;

  @OneToOne
  @JoinColumn(name = "job_position", referencedColumnName = "jobPosition")
  private JobPosition jobPosition;

}
