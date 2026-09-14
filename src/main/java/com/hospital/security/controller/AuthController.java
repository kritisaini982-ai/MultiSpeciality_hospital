package com.hospital.security.controller;
import com.hospital.security.model.User; import com.hospital.security.repository.UserRepository;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/auth") @CrossOrigin(origins="http://localhost:5173")
public class AuthController{
 private final UserRepository users; private final PasswordEncoder encoder;
 public AuthController(UserRepository u,PasswordEncoder e){users=u;encoder=e;}
 public record Login(@Email @NotBlank String email,@NotBlank String password){}
 public record Register(@NotBlank String name,@Email @NotBlank String email,@NotBlank String password){}
 @PostMapping("/login") public Map<String,Object> login(@Valid @RequestBody Login x){
  User u=users.findByEmail(x.email()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
  if(!encoder.matches(x.password(),u.getPassword()))throw new IllegalArgumentException("Invalid email or password");
  return Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail(),"role",u.getRole());
 }
 @PostMapping("/register") public Map<String,String> register(@Valid @RequestBody Register x){
  if(x.password().length()<8)throw new IllegalArgumentException("Password must be at least 8 characters");
  if(users.findByEmail(x.email()).isPresent())throw new IllegalArgumentException("Email already registered");
  users.save(new User(x.name(),x.email(),encoder.encode(x.password()),"patient")); return Map.of("message","Registration successful");
 }
}
