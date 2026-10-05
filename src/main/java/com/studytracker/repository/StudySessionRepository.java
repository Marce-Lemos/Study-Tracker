package com.studytracker.repository;

import com.studytracker.entity.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

    public List<StudySession> findByStudiedAtGreaterThanEqualAndStudiedAtLessThan(LocalDateTime inicio, LocalDateTime fim);
}
