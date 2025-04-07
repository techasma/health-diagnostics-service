package com.ignou.hds.HDS.repository;

import com.ignou.hds.HDS.model.TestBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBookingRepository extends JpaRepository<TestBooking, Long> {
    // Custom methods if needed
}
