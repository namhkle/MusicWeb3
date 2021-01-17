import React from 'react';
import './App.css';
import './index.css';
import Comment from "./components/Comment";
import DisplaySongs from './components/DisplaySongs';
import { Fragment } from 'react';
function App() {
  return (
    <Fragment>
      <Comment/>
      <DisplaySongs/>
    </Fragment>
  );
}

export default App;
