package ca.levio.technicaladvisorservice.service;

import ca.levio.technicaladvisorservice.entity.TechnicalAdvisor;
import ca.levio.technicaladvisorservice.repository.SkillsRepository;
import ca.levio.technicaladvisorservice.repository.TechnicalAdvisorRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TechnicalAdvisorService {

  private final TechnicalAdvisorRepository technicalAdvisorRepository;
  private final SkillsRepository skillsRepository;

  public TechnicalAdvisor  addTechnicalAdvisor(TechnicalAdvisor technicalAdvisor) {
/*    Collection<Skills> skills = technicalAdvisor.getSkills();
    skills.stream().filter(s-> s.getLevelOfExpertise().contains());*/
    return technicalAdvisorRepository.save(technicalAdvisor);
  }

  public List<TechnicalAdvisor> getAllTechnicalAdvisors() {
    return technicalAdvisorRepository.findAll();
  }

  public Optional<TechnicalAdvisor> getTechnicalAdvisorById(String id) {
    return  technicalAdvisorRepository.findById(id);
  }

  public void deleteTechnicalAdvisorById(String id) {
    technicalAdvisorRepository.deleteById(id);
  }

}