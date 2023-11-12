// EventList.js
import React, { useState, useEffect } from 'react';
import './EventList.css'

const EventList = () => {
    const [events, setEvents] = useState([]);

    useEffect(() => {
        fetchEvents();
    }, []);

    const formatDate = (dateString) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric', hour12: true };
        return new Intl.DateTimeFormat('en-US', options).format(new Date(dateString));
      };
    
    const fetchEvents = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/events');
            const data = await response.json();
            setEvents(data);
        } catch (error) {
            console.error('Error fetching events:', error);
        }
    };

    return (
        <div>
            <h1>Event List</h1>
            <ul className='event-list'>
                {events.map((event, index ) => (
                    <div key={index} className={`event-item ${index % 2 === 0 ? "evenList" : "oddList" }`}>
                    <div id="eventName">{event.eventName}</div>
                    <div id="eventTime">
                     Start Time: {formatDate(event.startDateandTime)} < br/> End Time: {formatDate(event.endDateandTime) }< br/><br/>
                    </div>
                </div>
                ))}
            </ul>
        </div>
    );
};

export default EventList;