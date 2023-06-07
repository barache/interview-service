package ca.levio.interviewservice.utils.convert;

import ca.levio.interviewservice.dto.JobPositionDto;
import ca.levio.interviewservice.entity.JobPosition;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JobPositionDtoConverter {
    private ModelMapper modelMapper;

    public JobPositionDto convertToJobPositionDto(JobPosition jobPosition){
        return modelMapper.map(jobPosition, JobPositionDto.class);
    }

    public JobPosition convertToJobPosition(JobPositionDto jobPositionDto){
        return modelMapper.map(jobPositionDto, JobPosition.class);
    }
}
