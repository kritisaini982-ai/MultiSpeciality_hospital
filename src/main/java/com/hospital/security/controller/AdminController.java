package com.hospital.security.controller;
import com.hospital.security.model.User; import com.hospital.security.repository.UserRepository; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/admin") @CrossOrigin(origins="http://localhost:5173")
public class AdminController{
 private final UserRepository repo; public AdminController(UserRepository r){repo=r;}
 @GetMapping("/patients") public List<User> patients(){return repo.findAll().stream().filter(x->"patient".equals(x.getRole())).toList();}
}
