import React from "react";
import { useState } from "react";

export const HandleClick = () => {
  const [count, setCount] = useState(0);

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Click</button>
      <p1>{count}</p1>
    </div>
  )
}

