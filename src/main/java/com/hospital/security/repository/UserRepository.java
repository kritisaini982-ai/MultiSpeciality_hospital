package com.hospital.security.repository;
import com.hospital.security.model.User; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long>{Optional<User> findByEmail(String email);}
