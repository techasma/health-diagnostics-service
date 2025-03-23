package com.ignou.hds.HDS.repository;


import com.ignou.hds.HDS.model.TestBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBookingRepository extends JpaRepository<TestBooking, Long> {

    // Custom method to find all test bookings by a specific user ID
    List<TestBooking> findByUserId(Long userId);

    // Custom method to find test bookings based on status (e.g., "Pending", "Completed")
    List<TestBooking> findByStatus(String status);
}