package com.studytracker.repository;

import com.studytracker.entity.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

    public List<StudySession> findByStudiedAtGreaterThanEqualAndStudiedAtLessThan(LocalDateTime inicio, LocalDateTime fim);

    @Query("""
    SELECT SUM(s.durationMinutes)
    FROM StudySession s
    WHERE s.studiedAt >= :inicio
      AND s.studiedAt < :fim
""")
    Long sumDurationBetween(LocalDateTime inicio, LocalDateTime fim);
}
