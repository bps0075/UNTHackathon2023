import React from 'react';
import CreateEvent from './addEvent';
import EventList from './EventList';
import './CombinedPage.css'; // You can create a CSS file for styling

const CombinedPage = () => {
  return (
    <div className="combined-page">
      <div className="left-panel">
        <EventList />
      </div>
      <div className="right-panel">
        <CreateEvent />
      </div>
    </div>
  );
};

export default CombinedPage;