package com.example.undergrad;

import com.example.undergrad.model.Database;
import com.example.undergrad.model.Events;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })

public class TimeManagementOrganizerApplication {

	public static void main(String[] args) {

		Database.createNewDatabase("events.db");
		Database.loadEvents("events.db");
		SpringApplication.run(TimeManagementOrganizerApplication.class, args);

	}

}
