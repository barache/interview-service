package ca.levio.technicaladvisorservice.service;

import ca.levio.technicaladvisorservice.entity.TechnicalAdvisor;
import ca.levio.technicaladvisorservice.repository.SkillsRepository;
import ca.levio.technicaladvisorservice.repository.TechnicalAdvisorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TechnicalAdvisorService {

    private final TechnicalAdvisorRepository technicalAdvisorRepository;
    private final SkillsRepository skillsRepository;

    public TechnicalAdvisor addTechnicalAdvisor(TechnicalAdvisor technicalAdvisor) {
/*    Collection<Skills> skills = technicalAdvisor.getSkills();
    skills.stream().filter(s-> s.getLevelOfExpertise().contains());*/
        return technicalAdvisorRepository.save(technicalAdvisor);
    }

    public Collection<TechnicalAdvisor> getAllTechnicalAdvisors() {
        return technicalAdvisorRepository.findAll();
    }

    public Optional<TechnicalAdvisor> getTechnicalAdvisorById(String id) {
        return technicalAdvisorRepository.findById(id);
    }

    public void deleteTechnicalAdvisorById(String id) {
        technicalAdvisorRepository.deleteById(id);
    }


    public Collection<TechnicalAdvisor> findAllTechnicalAdvisorEligible(String jobPosition, String levelOfExpertise, boolean active){
        return  technicalAdvisorRepository.findAllTechnicalAdvisorEligible(levelOfExpertise, jobPosition, active);
    }
}