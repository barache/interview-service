package ca.levio.technicaladvisorservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "skills")
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "skill_id")
  @JsonIgnore
  private UUID id;
  private String skill;
  private String levelOfExpertise;

  @ManyToOne(targetEntity = TechnicalAdvisor.class)
  private TechnicalAdvisor technicalAdvisor;
}
