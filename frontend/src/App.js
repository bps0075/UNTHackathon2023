import './App.css';

import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreateEvent from './addEvent';
//import EventList from './EventList';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/create-event" element={<CreateEvent />} />
      {/*  <Route path="/event-list" element={<EventList />} /> */}
      </Routes>
    </Router>
  );
}

export default App;