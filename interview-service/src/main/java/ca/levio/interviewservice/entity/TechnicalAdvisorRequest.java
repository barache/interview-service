package ca.levio.interviewservice.entity;

import ca.levio.interviewservice.utils.Response;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
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
public class TechnicalAdvisorRequest {
  @EmbeddedId
  private TechnicalAdvisorRequestId technicalAdvisorRequestId;
  private Response response;
  private LocalDateTime localDateTime;
  private String RecruiterRemark;
}