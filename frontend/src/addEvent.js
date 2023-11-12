import React, { useState } from 'react';
import './addEvent.css'
import { useNavigate } from 'react-router-dom';


const CreateEvent = ( { updateEventList }) => {
  const navigate = useNavigate();

  const [eventName, setEventName] = useState('');
  const [startTime, setStartTime] = useState('');
  const [endTime, setEndTime] = useState('');
  const [errorMessage, setError] = useState(null);
  const [info, setInfo] = useState(null);
  const resetErrorAndInfo = () => {
    setError(null);
    setInfo(null);
  };
  const handleCreateEvent = async (e) => {
    e.preventDefault();
    resetErrorAndInfo();
    try {
      if (!eventName || !startTime || !endTime) {
        setError('Please enter values for all fields');
        return;
      }
  
      if (startTime >= endTime) {
        setError('End time must be later than start time');
        return;
      }
  
      setError(null);
  
      // Perform create logic here 
      const response = await fetch('http://localhost:8080/api/events/checkAvailabilityAndAdd', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ eventName, startTime, endTime }),
      });
  
      if (!response.ok) {
        setInfo('Network response was not ok!');

        throw new Error('Network response was not ok');
      }
  
      // Assuming your API returns a boolean value indicating availability
      const isAvailable = await response.json();
  
      // Handle the availability response
      if (isAvailable) {
        setInfo('Event is added!');
        console.log('Event is added');
       // updateEventList(); // Call the prop function to fetch events, causes error

      }else{
        setInfo('Event conflicts others!');
        console.log('Other events conflict');
        // You might want to show a conflicts message or perform other actions
      }
  
      // Reset the form after handling availability check
      setEventName('');
      setStartTime('');
      setEndTime('');
    } catch (error) {
      setInfo('Error during API call!');
      console.error('Error during API call:', error);
    }
  };

  
  const checkAvailability = async (e) => {
    e.preventDefault();
    resetErrorAndInfo();
    try {
      if (!eventName || !startTime || !endTime) {
        setError('Please enter values for all fields');
        return;
      }
  
      if (startTime >= endTime) {
        setError('End time must be later than start time');
        return;
      }
  
      setError(null);
  
      // Perform availability check logic here 
      const response = await fetch('http://localhost:8080/api/events/checkAvailability', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ eventName, startTime, endTime }),
      });
  
      if (!response.ok) {
        setInfo('Network response was not ok!');

        throw new Error('Network response was not ok');
      }
  
      // Assuming your API returns a boolean value indicating availability
      const isAvailable = await response.json();
  
      // Handle the availability response
      if (isAvailable) {
        setInfo('Event is available!');
        console.log('Event is available');
        // You might want to show a success message or perform other actions
      } else {
        setInfo('Event conflicts others!');
        console.log('Other events conflict');
        // You might want to show a conflicts message or perform other actions
      }
  
      // Reset the form after handling availability check
      setEventName('');
      setStartTime('');
      setEndTime('');
    } catch (error) {
      setInfo('Error during API call!');
      console.error('Error during API call:', error);
    }
  };

  return (
    <div id='addEventMain'>
      <h2 id='HeaderaddEvent'>Create Event</h2>
      <form id='addEventForm'>
        <label id='inputEventName'>
          Event Name:
          <input type="text" required value={eventName}
            onChange={(e) => setEventName(e.target.value)}
          />
        </label>
        <br />
        <label id='inputStart'>
          Start Time: 
          <input
            type="datetime-local" required value={startTime}
            onChange={(e) => setStartTime(e.target.value)}
          />
        </label>
        <br />
        <label id='inputEnd'>
          End Time:
          <input
            type="datetime-local" required value={endTime}   onChange={(e) => setEndTime(e.target.value)}
          />
        </label>
        <br />
        <button type="input" onClick={handleCreateEvent}>
          Create Event
        </button>
        <button type="input" onClick={checkAvailability}>
          Check Availability
        </button>
        <button type="button" onClick={() => navigate('/event-list')}>
        Event List
      </button>
      </form>
      {errorMessage && ( //error && checks error first then
        <div className="popup-error">
          <div className="popup-content-error">
            <p>{errorMessage}</p>
            <button onClick={() => resetErrorAndInfo()}>Close</button>
          </div>
        </div>
      )}
        {info && ( //error && checks error first then
        <div className="info">
          <div className="info-content">
            <p>{info}</p>
            <button onClick={() => resetErrorAndInfo() }>Close</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default CreateEvent;