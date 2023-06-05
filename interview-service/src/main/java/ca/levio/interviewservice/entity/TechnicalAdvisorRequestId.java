package ca.levio.interviewservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class TechnicalAdvisorRequestId implements Serializable {
  @Column(name = "interview_id")
  private UUID interviewId;
  @Column(name = "technical_advisor_id")
  private String technicalAdvisorId;
}
