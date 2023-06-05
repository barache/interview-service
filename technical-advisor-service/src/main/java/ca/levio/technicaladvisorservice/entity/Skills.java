package ca.levio.technicaladvisorservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
}
