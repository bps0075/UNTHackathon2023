package com.example.undergrad.restAPI;

import com.example.undergrad.model.Events;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")

public class EventsController {

    @GetMapping
    public List<Events> getAllEvents() {
        // Dummy data for demonstration purposes
        System.out.println("Get");
        List<Events> eventsList = new ArrayList<>(); //need to be changed to get actual data
        eventsList.add(new Events(1, new Date(), new Date(), "Event 1"));
        eventsList.add(new Events(2, new Date(), new Date(), "Event 2"));
        eventsList.add(new Events(3, new Date(), new Date(), "Event 3"));

        return eventsList;
    }
}