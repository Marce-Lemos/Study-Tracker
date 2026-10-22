package com.studytracker;

import com.studytracker.dto.WeeklyStudySummary;
import com.studytracker.repository.StudySessionRepository;
import com.studytracker.service.StudySessionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.studytracker.entity.StudySession;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudySessionServiceTest {

    @Mock
    StudySessionRepository repository;
    @InjectMocks
    StudySessionService service;


    @Test
    void deveRetornarResumoSemanal() {
        LocalDate date = LocalDate.of(2026, 10, 14);

        LocalDate beginWeek = date.with(DayOfWeek.MONDAY);
        LocalDate endWeek = beginWeek.plusDays(6);

        LocalDateTime inicio = beginWeek.atStartOfDay();
        LocalDateTime fim = endWeek.plusDays(1).atStartOfDay();

        when(repository.sumDurationBetween(inicio, fim))
                .thenReturn(300L);

        StudySession session1 = new StudySession();
        StudySession session2 = new StudySession();

        when(repository.findByStudiedAtGreaterThanEqualAndStudiedAtLessThan(inicio, fim))
                .thenReturn(List.of(session1, session2));

        WeeklyStudySummary summary = service.getWeeklySummary(date);

        assertEquals(300L, summary.getTotalMinutes());
        assertEquals(2, summary.getTotalSessions());
    }


}


