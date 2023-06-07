package ca.levio.technicaladvisorservice.entity;

import jakarta.persistence.*;

import java.util.Collection;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "technicaladvisor")
public class TechnicalAdvisor {
    @Id
    @Column(name = "technical_advisor_id")
    private String id;
    private String name;
    private String email;
    private boolean active;

    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_advisor_id")
    private Collection<Skills> skills;
}
