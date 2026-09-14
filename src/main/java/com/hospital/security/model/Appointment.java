package com.hospital.security.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="appointments")
public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long patientId; private Long doctorId; private LocalDate appointmentDate;
 @Column(length=1000) private String reason;
 public Appointment(){} public Long getId(){return id;} public Long getPatientId(){return patientId;}
 public Long getDoctorId(){return doctorId;} public LocalDate getAppointmentDate(){return appointmentDate;} public String getReason(){return reason;}
 public void setPatientId(Long x){patientId=x;} public void setDoctorId(Long x){doctorId=x;}
 public void setAppointmentDate(LocalDate x){appointmentDate=x;} public void setReason(String x){reason=x;}
}
