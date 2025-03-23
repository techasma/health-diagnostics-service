package com.ignou.hds.HDS.controller;


import com.ignou.hds.HDS.model.TestBooking;
import com.ignou.hds.HDS.repository.TestBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test-booking")
public class TestBookingController {

    @Autowired
    private TestBookingRepository testBookingRepository;

    @GetMapping
    public List<TestBooking> getAllBookings() {
        return testBookingRepository.findAll();
    }

    @PostMapping("/book")
    public TestBooking bookTest(@RequestBody TestBooking booking) {
        return testBookingRepository.save(booking);
    }
}