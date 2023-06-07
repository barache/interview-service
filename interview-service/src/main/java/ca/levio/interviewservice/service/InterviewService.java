package ca.levio.interviewservice.service;

import ca.levio.interviewservice.dto.InterviewDto;
import ca.levio.interviewservice.dto.JobPositionDto;
import ca.levio.interviewservice.entity.Interview;
import ca.levio.interviewservice.repository.InterviewRepository;
import ca.levio.interviewservice.utils.convert.InterviewDtoConverter;
import ca.levio.interviewservice.utils.convert.JobPositionDtoConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InterviewService {
    private final InterviewRepository interviewRepository;
    private final InterviewDtoConverter interviewDtoConverter;
    private final JobPositionDtoConverter jobPositionDtoConverter;

    public Interview createInterview(Interview interview) {
        log.info("Interview with id: {} was created succesfully.", interview.getId());
        interviewRepository.save(interview);
        return interview;
    }

    public Collection<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Optional<Interview> getInterviewById(String id) {
        return interviewRepository.findById(id);
    }

    public void deleteTechnicalAdvisorById(String id) {
        interviewRepository.deleteById(id);
    }

    public void updateInterview(Interview interview) {
        log.info("Interview with id: {} was updated succesfully.", interview.getId());
        JobPositionDto jobPositionDto = jobPositionDtoConverter.convertToJobPositionDto(interview.getJobPosition());
        InterviewDto interviewDto = interviewDtoConverter.convertToInterviewDto(interview);
        interview = interviewDtoConverter.convertToInterview(interviewDto);
        interview.setJobPosition(jobPositionDtoConverter.convertToJobPosition(jobPositionDto));
        interviewRepository.save(interview);
    }
}
