import React from 'react';
import { Component } from 'react';
import TextArea from "./TextArea";
import {test, write} from "./CommentContainer";

class Comment extends Component {
  state = {
    thing: "sup"
  }

  render(){
    
    return (
      <div> 
          <TextArea song={test} write={write}/>
          <p>{this.state.thing}</p>
      </div>
    );
  }
}
  

export default Comment;
    