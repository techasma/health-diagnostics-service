package com.ignou.hds.HDS.service;

import com.ignou.hds.HDS.model.TestBooking;
import com.ignou.hds.HDS.repository.TestBookingRepository;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestBookingService {

    @Autowired
    private TestBookingRepository testBookingRepository;

    @Transactional
    public TestBooking bookTest(TestBooking booking) {
        try {
            // Save the test booking, Hibernate will check the version and apply optimistic locking
            return testBookingRepository.save(booking);
        } catch (StaleObjectStateException e) {
            // Handle the StaleObjectStateException (e.g., notify the user, retry, etc.)
            throw new RuntimeException("The test booking has been updated by another user. Please refresh and try again.");
        }
    }

    @Transactional
    public TestBooking updateTestBooking(TestBooking booking) {
        // Make sure the entity is fetched first (i.e., attached to the session)
        TestBooking existingBooking = testBookingRepository.findById(booking.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Test Booking not found"));

        // Update the fields as necessary
        existingBooking.setStatus(booking.getStatus());
        existingBooking.setAppointmentDate(booking.getAppointmentDate());

        return testBookingRepository.save(existingBooking); // Save and check version
    }
}
