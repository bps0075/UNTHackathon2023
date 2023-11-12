package com.example.undergrad.restAPI;

import com.example.undergrad.model.Events;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")

public class EventsController {

    @GetMapping("/getAllEvents")
    public List<Events> getAllEvents() {
        // Dummy data for demonstration purposes
        System.out.println("Get");
        List<Events> eventsList = new ArrayList<>(); //need to be changed to get actual data
        eventsList.add(new Events( new Date(), new Date(), "Event 1"));
        eventsList.add(new Events( new Date(), new Date(), "Event 2"));
        eventsList.add(new Events( new Date(), new Date(), "Event 3"));

        //return eventsList;
       return Events.eventList;
    }

    // Endpoint to check availability without adding the event
    @PostMapping("/checkAvailability")
    public ResponseEntity<Boolean> checkAvailability(@RequestBody Events event) {

        return ResponseEntity.ok(Events.checkAvability(event));
    }

    // Endpoint to check availability and add the event
    @PostMapping("/checkAvailabilityAndAdd")
    public ResponseEntity<Boolean> checkAvailabilityAndAdd(@RequestBody Events event) {
        // For demonstration purposes, always returning "Event added"
        return ResponseEntity.ok(Events.addEvent(event));
    }
}