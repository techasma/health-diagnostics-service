package com.ignou.hds.HDS.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_bookings")
public class TestBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;  // Unique Appointment ID (Primary Key)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Patient ID (Foreign Key)

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;  // Selected Test (Foreign Key)

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;  // Date and Time of Appointment

    @Column(name = "status", length = 255, nullable = false)
    private String status = "Pending";  // Default Status (Pending)

    @Column(name = "test_type", length = 255)
    private String testType; // Optional Test Type

    @Version
    @Column(name = "version")
    private Integer version = 0;  // Version for Optimistic Locking

    public void setUser(Optional<User> byId) {
    }
}
