import React from 'react';
import axios from 'axios';
import { useState, useEffect } from "react";

const TextArea = (props) =>{
  const [count, setCount] = useState(0);
  const [commentVal, setCommentVal] = useState("");

  useEffect(() => {
    document.getElementById('commentCount').innerHTML = "Comments: " + count;
  });


  const HandleClickPress = (e) => {
    let cm = document.getElementById('commentA').value;
    var node = document.createElement("p");
    var textnode = document.createTextNode(cm);
    node.appendChild(textnode);
    document.getElementById("commentSection").appendChild(node);
    document.getElementById('commentA').value = "";
    var objDiv = document.getElementById("commentSection");
    objDiv.scrollTop = objDiv.scrollHeight;
    setCount(count+1);
  }
  
  const HandleKeyPress = (e) => {
    if (e.key === 'Enter') {
      var cm = document.getElementById('commentA').value;
      var node = document.createElement("p");
      var textnode = document.createTextNode(cm);
      node.appendChild(textnode);
      var n = document.getElementById("commentSection").appendChild(node);
      document.getElementById('commentA').value = "";
      var objDiv = document.getElementById("commentSection");
      objDiv.scrollTop = objDiv.scrollHeight;
      setCount(count+1);
      setCommentVal(e.target.value);
      console.log(commentVal);
    }
  }

  return (
    <div>
      <textarea placeholder="Comment" id="commentA" onKeyPress={HandleKeyPress}  rows="3" cols="45"></textarea>
      <button id="commentBt" onClick={props.write} >Comment</button>
      <p1>{props.song}</p1>
    </div>
  );
}

export default TextArea;