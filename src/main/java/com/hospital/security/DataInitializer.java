package com.hospital.security;

import com.hospital.security.model.Doctor;
import com.hospital.security.model.User;
import com.hospital.security.repository.DoctorRepository;
import com.hospital.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByEmail("patient@hospital.local").isEmpty()) {
                User patient = new User();
                patient.setName("Test Patient");
                patient.setEmail("patient@hospital.local");
                patient.setPassword(passwordEncoder.encode("Patient@123"));
                patient.setRole("patient");
                userRepository.save(patient);
            }

            if (userRepository.findByEmail("admin@hospital.local").isEmpty()) {
                User admin = new User();
                admin.setName("Hospital Admin");
                admin.setEmail("admin@hospital.local");
                admin.setPassword(passwordEncoder.encode("Admin@123"));
                admin.setRole("admin");
                userRepository.save(admin);
            }

            // Doctor 1: Dr. A. Sharma
            if (userRepository.findByEmail("doctor@hospital.local").isEmpty()) {
                User doctor = new User();
                doctor.setName("Dr. A. Sharma");
                doctor.setEmail("doctor@hospital.local");
                doctor.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor.setRole("doctor");
                userRepository.save(doctor);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "doctor@hospital.local".equals(d.getEmail()))) {
                Doctor doc1 = new Doctor();
                doc1.setName("Dr. A. Sharma");
                doc1.setSpecialization("Cardiology");
                doc1.setEmail("doctor@hospital.local");
                doctorRepository.save(doc1);
            }

            // Doctor 2: Dr. Smith
            if (userRepository.findByEmail("smith@hospital.local").isEmpty()) {
                User doctor2 = new User();
                doctor2.setName("Dr. Smith");
                doctor2.setEmail("smith@hospital.local");
                doctor2.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor2.setRole("doctor");
                userRepository.save(doctor2);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "smith@hospital.local".equals(d.getEmail()))) {
                Doctor doc2 = new Doctor();
                doc2.setName("Dr. Smith");
                doc2.setSpecialization("Neurology");
                doc2.setEmail("smith@hospital.local");
                doctorRepository.save(doc2);
            }

            // Doctor 3: Dr. Verma
            if (userRepository.findByEmail("verma@hospital.local").isEmpty()) {
                User doctor3 = new User();
                doctor3.setName("Dr. Verma");
                doctor3.setEmail("verma@hospital.local");
                doctor3.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor3.setRole("doctor");
                userRepository.save(doctor3);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "verma@hospital.local".equals(d.getEmail()))) {
                Doctor doc3 = new Doctor();
                doc3.setName("Dr. Verma");
                doc3.setSpecialization("General Medicine");
                doc3.setEmail("verma@hospital.local");
                doctorRepository.save(doc3);
            }

            // Doctor 4: Dr. Mehta
            if (userRepository.findByEmail("mehta@hospital.local").isEmpty()) {
                User doctor4 = new User();
                doctor4.setName("Dr. Mehta");
                doctor4.setEmail("mehta@hospital.local");
                doctor4.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor4.setRole("doctor");
                userRepository.save(doctor4);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "mehta@hospital.local".equals(d.getEmail()))) {
                Doctor doc4 = new Doctor();
                doc4.setName("Dr. Mehta");
                doc4.setSpecialization("Orthopedics");
                doc4.setEmail("mehta@hospital.local");
                doctorRepository.save(doc4);
            }

            // Doctor 5: Dr. Singh
            if (userRepository.findByEmail("singh@hospital.local").isEmpty()) {
                User doctor5 = new User();
                doctor5.setName("Dr. Singh");
                doctor5.setEmail("singh@hospital.local");
                doctor5.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor5.setRole("doctor");
                userRepository.save(doctor5);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "singh@hospital.local".equals(d.getEmail()))) {
                Doctor doc5 = new Doctor();
                doc5.setName("Dr. Singh");
                doc5.setSpecialization("Dermatology");
                doc5.setEmail("singh@hospital.local");
                doctorRepository.save(doc5);
            }

            // Doctor 6: Dr. Rao
            if (userRepository.findByEmail("rao@hospital.local").isEmpty()) {
                User doctor6 = new User();
                doctor6.setName("Dr. Rao");
                doctor6.setEmail("rao@hospital.local");
                doctor6.setPassword(passwordEncoder.encode("Doctor@123"));
                doctor6.setRole("doctor");
                userRepository.save(doctor6);
            }

            if (doctorRepository.findAll().stream().noneMatch(d -> "rao@hospital.local".equals(d.getEmail()))) {
                Doctor doc6 = new Doctor();
                doc6.setName("Dr. Rao");
                doc6.setSpecialization("Pediatrics");
                doc6.setEmail("rao@hospital.local");
                doctorRepository.save(doc6);
            }
        };
    }
}