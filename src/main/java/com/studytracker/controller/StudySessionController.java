package com.studytracker.controller;

import com.studytracker.entity.StudySession;
import com.studytracker.repository.StudySessionRepository;
import com.studytracker.service.StudySessionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studies")
public class StudySessionController {

    private final StudySessionRepository repository;
    private final StudySessionService service;

    public StudySessionController(StudySessionRepository repository, StudySessionService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<StudySession> findAll() {
        return service.findAll();
    }

    @PostMapping
    public StudySession saveSession(@Valid @RequestBody StudySession session){
        return service.saveSession(session);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudySession> findById(@PathVariable Long id) {

        Optional<StudySession> session = service.findById(id);

        if (session.isPresent()){
            return ResponseEntity.ok(session.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudySession> updateSession(@PathVariable Long id,
                                                      @Valid
                                                      @RequestBody StudySession updatedSession) {
        Optional<StudySession> session = service.updateSession(updatedSession, id);

        if (session.isPresent()){
            StudySession newSession = session.get();

            return ResponseEntity.ok(newSession);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}
