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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
public class TimeManagementOrganizerApplication {

	private static LocalDate plannedDate = null;
	private static LocalTime startTime = null;
	private static LocalTime endTime = null;
	private static String name = null;
	private static String location = null;
	private static String scheduleType = null;
	
	public static void main(String[] args) {

		Database.createNewDatabase("events.db");
		Database.loadEvents("events.db");
		SpringApplication.run(TimeManagementOrganizerApplication.class, args);

		//Below is tested data that can be used for showing how the event/class would be set
		/*System.out.println("Below is default tested data: ");
		//Default data variables for the date
		int year = 2023;
		int month = 11;
		int day = 25;
		int hour = 11;
		int duration = 2;
		int minute = 0;

		//Default variable for the date
		plannedDate = LocalDate.of(year, month, day);
		//date = Date.UTC(month, day, year);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		System.out.println("Planned future date is " + plannedDate.format(formatter));

		//Default variables for the time
		//startTime = LocalDateTime.of(year, month, day, hour, 0);
		startTime = LocalTime.of(hour, minute, 0);
		ZoneId zone = ZoneId.systemDefault();
		System.out.println("The event starts at " + startTime);
		hour = hour + duration;
		//endTime = LocalDateTime.of(year, month, day, hour+2, 0);
		endTime = LocalTime.of(hour, minute, 0);
		//These if statements below check if the time variables are too high
		if(hour > 24) {
			hour = hour - 24;
			day++;
			if(day > 31) {
				day = day - 31;
				month++;
				if(month > 12) {
					month = month - 12;
					year++; //2023 would become 2024
				}
			}

		}
		System.out.println("The event ends at " + endTime);

		name = "UNT Football Game";
		location = "1251 Bonnie Brae St. Denton, TX 76205";
		scheduleType = "event";
		System.out.println("The name of the " + scheduleType + " is " + name +
				" and the location is at " + location);*/
	}

}
