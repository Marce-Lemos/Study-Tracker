package com.studytracker.service;

import com.studytracker.entity.StudySession;
import com.studytracker.repository.StudySessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

            session.setNotes(updatedSession.getNotes());
            session.setStudiedAt(updatedSession.getStudiedAt());
            session.setDurationMinutes(updatedSession.getDurationMinutes());
            repository.save(session);

            return Optional.of(session);
        } else {
            return Optional.empty();
        }
    }


}
