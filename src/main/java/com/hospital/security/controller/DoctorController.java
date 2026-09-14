package com.hospital.security.controller;
import com.hospital.security.model.Doctor; import com.hospital.security.repository.DoctorRepository; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/doctors") @CrossOrigin(origins="http://localhost:5173")
public class DoctorController{
 private final DoctorRepository repo; public DoctorController(DoctorRepository r){repo=r;}
 @GetMapping public List<Doctor> all(@RequestParam(defaultValue="") String q){
  return q.isBlank()?repo.findAll():repo.findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(q,q);
 }
}
