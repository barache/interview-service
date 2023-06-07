package ca.levio.interviewservice.dto;

import lombok.Data;

@Data
public class InterviewDto {
    private String id;
    private String recruiter;
    private String email;
    private String applicant;
    private String levelOfExpertise;
    private String description;
    private boolean urgency;
}
