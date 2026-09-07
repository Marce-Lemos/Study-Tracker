package com.studytracker.controller;

import com.studytracker.entity.StudySession;
import com.studytracker.repository.StudySessionRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studies")
public class StudySessionController {

    private final StudySessionRepository repository;

    public StudySessionController(StudySessionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StudySession> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public StudySession saveSession(@Valid @RequestBody StudySession session){
        return repository.save(session);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudySession> findById(@PathVariable Long id) {

        Optional<StudySession> session = repository.findById(id);

        if (session.isPresent()){
            return ResponseEntity.ok(session.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudySession> updateSession(@PathVariable Long id, @Valid @RequestBody StudySession updatedSession) {
        Optional<StudySession> oldSession = repository.findById(id);

        if (oldSession.isPresent()){
            StudySession session = oldSession.get();

            session.setDurationMinutes(updatedSession.getDurationMinutes());
            session.setStudiedAt(updatedSession.getStudiedAt());
            session.setNotes(updatedSession.getNotes());

            repository.save(session);

            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
