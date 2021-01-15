import React from 'react';
import { useState, useEffect } from "react";

function TextArea() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    document.getElementById('commentCount').innerHTML = "Comments: " + count;
  });

  const HandleClickPress = () => {
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
  
  const HandleKeyPress = event => {
    if (event.key === 'Enter') {
      var cm = document.getElementById('commentA').value;
      var node = document.createElement("p");
      var textnode = document.createTextNode(cm);
      node.appendChild(textnode);
      var n = document.getElementById("commentSection").appendChild(node);
      document.getElementById('commentA').value = "";
      var objDiv = document.getElementById("commentSection");
      objDiv.scrollTop = objDiv.scrollHeight;
      setCount(count+1);
    }
  }

  return (
    <div>
      <textarea placeholder="Comment" id="commentA" onKeyPress={HandleKeyPress}  rows="3" cols="45"></textarea>
      <button id="commentBt" onClick={HandleClickPress}>Comment</button>
    </div>
  );
}

export default TextArea;