// EventList.js
import React, { useState, useEffect } from 'react';

const EventList = () => {
    const [events, setEvents] = useState([]);

    useEffect(() => {
        fetchEvents();
    }, []);

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
            <ul>
                {events.map(event => (
                    <li key={event.eventId}>
                        {event.eventName} - {event.startDateAndTime} to {event.endDateAndTime}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default EventList;