package ca.levio.technicaladvisorservice.repository;

import ca.levio.technicaladvisorservice.entity.TechnicalAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TechnicalAdvisorRepository extends JpaRepository<TechnicalAdvisor, String> {

    @Query(value = "SELECT t.* FROM technicalAdvisor t , skills s " +
            "WHERE t.technical_advisor_id = s.technical_advisor_id " +
            "AND s.level_of_expertise >= ?1 " +
            "AND s.skill = ?2" +
            "AND t.active = ?3 ", nativeQuery = true)
    Collection<TechnicalAdvisor> findAllTechnicalAdvisorEligible(String level, String skill, boolean active);
}