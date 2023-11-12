package com.example.undergrad.model;


import java.util.Date;


public class Events {
    private String eventName;
    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


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


    public Events(int eventid, Date startDateandTime, Date endDateandTime, String eventName) {
        this.eventid = eventid;
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



}
