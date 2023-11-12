import React, { useState } from 'react';
import CreateEvent from './addEvent';
import EventList from './EventList';
import './CombinedPage.css'; // You can create a CSS file for styling

const CombinedPage = () => {
    const [events, setEvents] = useState([]);

  const fetchEvents = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/events/getAllEvents');
      const data = await response.json();
      setEvents(data);
    } catch (error) {
      console.error('Error fetching events:', error);
    }
  };

  const updateEventList = async () => {
    await fetchEvents();
  };

  return (
    <div className="combined-page">
      <div className="left-panel">
        {/* Pass events as a prop to EventList */}

        <EventList events={events}/>
      </div>
      <div className="right-panel">
               {/* Pass updateEventList as a prop to CreateEvent */} 
        <CreateEvent updateEventList={updateEventList} />
      </div>
    </div>
  );
};

export default CombinedPage;