package ca.levio.interviewservice.controller;

import ca.levio.interviewservice.entity.Interview;
import ca.levio.interviewservice.exception.ResourceNotFoundException;
import ca.levio.interviewservice.service.InterviewService;
import ca.levio.interviewservice.utils.MagicResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/interviews/")
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        interviewService.createInterview(interview);
        return ResponseEntity.ok(interview);
    }

    @GetMapping
    ResponseEntity<Collection<Interview>> getAllIntereviews() {
        Collection<Interview> interviews = interviewService.getAllInterviews();
        return interviews.isEmpty() ?
                ResponseEntity.ok().build() :
                ResponseEntity.ok(interviews);
    }

    @GetMapping(value = "{id}")
    ResponseEntity<Interview> getInterviewById(@PathVariable String id) {
        return MagicResponse.of(interviewService.getInterviewById(id))
                .ifPresentOrElse(HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteInterviewById(@PathVariable String id) {
        interviewService.deleteTechnicalAdvisorById(id);
        return new ResponseEntity<>(String.format("interview with id: [%s] successfully deleted!", id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable String id, @RequestBody Interview interview) {

        Optional<Interview> interviewExist = interviewService.getInterviewById(id);
        if(interviewExist.isEmpty()){
            new ResourceNotFoundException("Interview not exist with id: " + id);
        }
        interviewService.updateInterview(interview);

        return ResponseEntity.ok(interview);
    }

}
