package ca.levio.technicaladvisorservice.repository;

import ca.levio.technicaladvisorservice.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillsRepository extends JpaRepository<Skills, UUID> {
}
