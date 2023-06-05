package ca.levio.interviewservice.service;

import ca.levio.interviewservice.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InterviewService {
    private final InterviewRepository interviewRepository;
}
