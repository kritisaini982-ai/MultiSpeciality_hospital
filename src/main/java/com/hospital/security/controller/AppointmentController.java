package com.hospital.security.controller;

import com.hospital.security.model.Appointment;
import com.hospital.security.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {
    private final AppointmentRepository repo;

    public AppointmentController(AppointmentRepository r) {
        repo = r;
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment a) {
        return repo.save(a);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> patient(@PathVariable Long id) {
        return repo.findByPatientId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}