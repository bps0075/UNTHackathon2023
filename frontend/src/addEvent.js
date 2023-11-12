import React, { useState } from 'react';

const CreateEvent = () => {
  const [eventName, setEventName] = useState('');
  const [startTime, setStartTime] = useState('');
  const [endTime, setEndTime] = useState('');

  const handleCreateEvent = () => {
    // Perform event creation logic here (e.g., make an API request)
    console.log('Creating event with:', { eventName, startTime, endTime });
    // Reset the form after handling event creation
    setEventName('');
    setStartTime('');
    setEndTime('');
  };

  const checkAvailability = () => {
    // Perform availability check logic here (e.g., make an API request)
    console.log('Checking availability for:', { eventName, startTime, endTime });
  };

  return (
    <div>
      <h2>Create Event</h2>
      <form>
        <label>
          Event Name:
          <input
            type="text"
            value={eventName}
            onChange={(e) => setEventName(e.target.value)}
          />
        </label>
        <br />
        <label>
          Start Time:
          <input
            type="datetime-local"
            value={startTime}
            onChange={(e) => setStartTime(e.target.value)}
          />
        </label>
        <br />
        <label>
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
    </div>
  );
};

export default CreateEvent;