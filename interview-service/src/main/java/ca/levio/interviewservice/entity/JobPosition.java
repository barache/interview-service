package ca.levio.interviewservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPosition {
  @Id
  @Column(nullable = false)
  private String jobPosition;
  private String lineOfBusiness;
  private String hierarchy;
  @OneToOne(mappedBy = "jobPosition")
  @JsonIgnore
  private Interview interview;
}
