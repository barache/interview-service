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
import java.util.List;

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
/*
  @GetMapping
  public ResponseEntity<List<TechnicalAdvisor>>getAllTechnicalAdvisors(){
    List<TechnicalAdvisor>technicalAdvisors = technicalAdvisorService.getAllTechnicalAdvisors();
    return new ResponseEntity<>(technicalAdvisors, HttpStatus.OK);
  }
*/

  @GetMapping("{id}")
  ResponseEntity<TechnicalAdvisor> getTechnicalAdvisorById(@PathVariable String id)  {
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



}
