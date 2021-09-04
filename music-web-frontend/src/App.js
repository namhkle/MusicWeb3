import React from 'react';
import './App.css';
import './index.css';
import Comment from "./components/Comment";
import {HandleClick} from "./components/HandleClick";
import { Fragment } from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import SongListPage from "./components/SongListPage";

function App() {
  return (
    /*<Fragment>
      <Comment/>
      <DisplaySongs/>
    </Fragment>*/

    <div>
      <BrowserRouter>
        <Switch>
          <Route path="/comment" component={Comment} />
          <Route path="/practice" component={HandleClick} />
          <Route path="/songs/:id?" component={SongListPage} />
        </Switch>   
      </BrowserRouter>
    </div>
  )

}

export default App;
