package com.studytracker.service;

import com.studytracker.entity.StudySession;
import com.studytracker.exception.StudyDurationException;
import com.studytracker.repository.StudySessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudySessionService {

    private final StudySessionRepository repository;

    public StudySessionService(StudySessionRepository repository) {
        this.repository = repository;
    }

    public List<StudySession> findAll (){
        return repository.findAll();
    }

    public StudySession saveSession (StudySession session){
        if (session.getDurationMinutes() > 720) {
            throw new StudyDurationException("A duração máxima é de 720 minutos!");
        }
        return repository.save(session);
    }

    public Optional<StudySession> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<StudySession> updateSession(StudySession updatedSession, Long id){
        Optional<StudySession> oldSession = repository.findById(id);

        if (oldSession.isPresent()){
            StudySession session = oldSession.get();

            if (updatedSession.getDurationMinutes() > 720) {
                throw new StudyDurationException("A duração máxima é de 720 minutos!");
            }
            session.setDurationMinutes(updatedSession.getDurationMinutes());
            session.setNotes(updatedSession.getNotes());
            session.setStudiedAt(updatedSession.getStudiedAt());
            repository.save(session);

            return Optional.of(session);
        } else {
            return Optional.empty();
        }
    }

    public List<StudySession> findByDate(LocalDate date){
        LocalDateTime inicio = date.atStartOfDay();
        LocalDateTime fim = date.plusDays(1).atStartOfDay();

        return repository.findByStudiedAtGreaterThanEqualAndStudiedAtLessThan(inicio, fim);
    }

    public Long getTotalMinutesByDate(LocalDate date) {
        LocalDateTime inicio = date.atStartOfDay();
        LocalDateTime fim = date.plusDays(1).atStartOfDay();

        Long total = repository.sumDurationBetween(inicio, fim);
        if (total == null){
            return 0L;
        }
        return total;
    }

}
