import React, { useState } from 'react';
import './addEvent.css'

const CreateEvent = () => {
  const [eventName, setEventName] = useState('');
  const [startTime, setStartTime] = useState('');
  const [endTime, setEndTime] = useState('');
  const [error, setError] = useState('');

  const handleCreateEvent = () => {
    if (!eventName || !startTime || !endTime) {
        setError('Please enter values for all fields');
        return;
      }

    if (startTime >= endTime) {
        setError('End time must be later than start time');
        return;
    }
    setError(null); //as not meet any invalid condtion

    // Perform event creation logic here (e.g., make an API request)
    console.log('Creating event with:', { eventName, startTime, endTime });
    // Reset the form after handling event creation
    setEventName('');
    setStartTime('');
    setEndTime('');
  };


  
  const checkAvailability = () => {
    if (!eventName || !startTime || !endTime) {
        setError('Please enter values for all fields');
        return;
    }

    if (startTime >= endTime) {
        setError('End time must be later than start time');
        return;
    }
    
    setError(null); //as not meet any invalid condtion
    // Perform availability check logic here (e.g., make an API request)
    console.log('Checking availability for:', { eventName, startTime, endTime });
  };

  return (
    <div id='addEventMain'>
      <h2 id='HeaderaddEvent'>Create Event</h2>
      <form id='addEventForm'>
        <label id='inputEventName'>
          Event Name:
          <input
            type="text"
            value={eventName}
            onChange={(e) => setEventName(e.target.value)}
          />
        </label>
        <br />
        <label id='inputStart'>
          Start Time: 
          <input
            type="datetime-local"
            value={startTime}
            onChange={(e) => setStartTime(e.target.value)}
          />
        </label>
        <br />
        <label id='inputEnd'>
          End Time:
          <input
            type="datetime-local"
            value={endTime}
            onChange={(e) => setEndTime(e.target.value)}
          />
        </label>
        <br />
        <button type="button" onClick={handleCreateEvent}>
          Create Event
        </button>
        <button type="button" onClick={checkAvailability}>
          Check Availability
        </button>
      </form>
      {error && ( //error && checks error first then
        <div className="popup">
          <div className="popup-content">
            <p>{error}</p>
            <button onClick={() => setError(null)}>Close</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default CreateEvent;