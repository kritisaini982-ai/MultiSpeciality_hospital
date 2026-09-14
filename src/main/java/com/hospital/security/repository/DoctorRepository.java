package com.hospital.security.repository;
import com.hospital.security.model.Doctor; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
 List<Doctor> findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(String n,String s);
}
