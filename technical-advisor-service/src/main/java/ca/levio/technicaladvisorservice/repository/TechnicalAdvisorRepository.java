package ca.levio.technicaladvisorservice.repository;

import ca.levio.technicaladvisorservice.entity.TechnicalAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalAdvisorRepository extends JpaRepository<TechnicalAdvisor, String> {

}