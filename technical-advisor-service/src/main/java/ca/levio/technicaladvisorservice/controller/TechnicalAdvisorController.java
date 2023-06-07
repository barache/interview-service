package ca.levio.technicaladvisorservice.controller;

import ca.levio.technicaladvisorservice.entity.TechnicalAdvisor;
import ca.levio.technicaladvisorservice.service.TechnicalAdvisorService;
import ca.levio.technicaladvisorservice.utils.MagicResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/technical-advisors/")
public class TechnicalAdvisorController {

    private final TechnicalAdvisorService technicalAdvisorService;

    @GetMapping
    ResponseEntity<Collection<TechnicalAdvisor>> getAllTechnicalAdvisors() {

        Collection<TechnicalAdvisor> technicalAdvisors = technicalAdvisorService.getAllTechnicalAdvisors();
        return technicalAdvisors.isEmpty() ?
                ResponseEntity.ok().build() :
                ResponseEntity.ok(technicalAdvisors);
    }

    @GetMapping("{id}")
    ResponseEntity<TechnicalAdvisor> getTechnicalAdvisorById(@PathVariable String id) {
        return MagicResponse.of(technicalAdvisorService.getTechnicalAdvisorById(id))
                .ifPresentOrElse(HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTechnicalAdvisorById(@PathVariable String id) {
        technicalAdvisorService.deleteTechnicalAdvisorById(id);
        return new ResponseEntity<>(String.format("technical advisor with id: [%s] successfully deleted!", id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TechnicalAdvisor> addTechnicalAdvisor(@RequestBody TechnicalAdvisor technicalAdvisor) {
        technicalAdvisorService.addTechnicalAdvisor(technicalAdvisor);
        return ResponseEntity.ok(technicalAdvisor);
    }

    @GetMapping("/eligible/{skill}/{level}")
    ResponseEntity<Collection<TechnicalAdvisor>> getAllTechnicalAdvisorsWithSkillAndLevel(
            @PathVariable String skill, @PathVariable String level) {
        Collection<TechnicalAdvisor> technicalAdvisors = technicalAdvisorService
                .findAllTechnicalAdvisorEligible(skill, level, true);
        return technicalAdvisors.isEmpty() ?
                ResponseEntity.ok().build() :
                ResponseEntity.ok(technicalAdvisors);
    }

}