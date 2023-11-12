package com.example.undergrad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


@Entity
public class Events implements Comparable<Events> {

    public static ArrayList<Events> eventList = new ArrayList<>();


    private static int currMaxIndex = 0; //for used for automatic eventID assign


    public static boolean checkAvability(Events event){
        for(Events other : eventList){
            if(other.isConflict(event)){
                return false;
            }
        }
        return true;
    }
    public static boolean addEvent(Events event){ //maintain sorted
        if(checkAvability(event)){
            eventList.add(event);
            currMaxIndex = Math.max(currMaxIndex, event.getEventid()); //update currMaxIndex
            Database.updateEvents("events.db", event);
            Collections.sort(eventList); //can be improved by binanry serach then insert (n log n to n)
            return true;
        }else{
            return false;
        }
    }

    private String eventName;
    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    @Id
    private int eventid;
    private Date startDateandTime;
    private Date endDateandTime;

    public String geteventName() {
        return eventName;
    }

    public void seteventName(String evenName) {
        this.eventName = evenName;
    }


    public Date getStartDateandTime() {
        return startDateandTime;
    }

    public void setStartDateandTime(Date startDateandTime) {
        this.startDateandTime = startDateandTime;
    }


    public Date getEndDateandTime() {
        return endDateandTime;
    }

    public void setEndDateandTime(Date endDateandTime) {
        this.endDateandTime = endDateandTime;
    }

    public Events(@JsonProperty("startTime") Date startDateandTime,
                  @JsonProperty("endTime") Date endDateandTime,
                  @JsonProperty("eventName") String eventName) {
        this.eventid = currMaxIndex + 1;
        currMaxIndex++;
        this.startDateandTime = startDateandTime;
        this.endDateandTime = endDateandTime;
        this.eventName = eventName;
    }

    public boolean isConflict(Events e2){
        Date startOther = e2.getStartDateandTime();
        Date endOther = e2.getEndDateandTime();

        if(this.startDateandTime.getTime() < startOther.getTime()){ //if this event starts ealier than e2
            return this.endDateandTime.getTime() >= startOther.getTime(); //if e2 start before finishing this event, then it's conflict
        }else{ //if this event not starts ealier than e2
            return this.startDateandTime.getTime() <= endOther.getTime();
        }

    }

   @Override
    public int compareTo(Events event) {
        long thisStart = this.startDateandTime.getTime();
        long eventStart = event.getStartDateandTime().getTime();
        return Long.compare(thisStart, eventStart);
    }
}
