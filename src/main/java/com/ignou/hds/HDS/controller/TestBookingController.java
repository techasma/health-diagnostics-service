package com.ignou.hds.HDS.controller;

import com.ignou.hds.HDS.model.TestBooking;
import com.ignou.hds.HDS.model.User;
import com.ignou.hds.HDS.repository.TestBookingRepository;
import com.ignou.hds.HDS.repository.UserRepository;
import com.ignou.hds.HDS.service.TestBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test-booking")
public class TestBookingController {

    @Autowired
    private TestBookingService testBookingService;

    @Autowired
    private TestBookingRepository testBookingRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<TestBooking> getAllBookings() {
        return testBookingRepository.findAll(); // Fetch all bookings
    }

    @GetMapping("id")
    public Optional<User> findUser() {
        return userRepository.findById(7L);
    }

    @PostMapping("/book")
    public TestBooking bookTest(@RequestBody TestBooking booking) {

        Optional<User> user =userRepository.findById(7L);
        User  user1=  new User();
       // user1.setId(user.);
        booking.getUser().setId(user.get().getId());

        return testBookingService.bookTest(booking); // Book a new test
    }

    @PutMapping("/update")
    public TestBooking updateTestBooking(@RequestBody TestBooking booking) {
        return testBookingService.updateTestBooking(booking); // Update an existing test booking
    }
}
