package ca.levio.interviewservice.utils.convert;

import ca.levio.interviewservice.dto.InterviewDto;
import ca.levio.interviewservice.entity.Interview;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InterviewDtoConverter {
    private ModelMapper modelMapper;

    public InterviewDto convertToInterviewDto(Interview interview){
        return modelMapper.map(interview, InterviewDto.class);
    }

    public Interview convertToInterview(InterviewDto interviewDto){
        return modelMapper.map(interviewDto, Interview.class);
    }
}
