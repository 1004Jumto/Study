import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Body from "./component/Body";
import Footer from "./component/Footer";

function Header() {
  return (
    <header>
      <h1>헤더</h1>
    </header>
  );
}

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <div>안녕</div>
      <Header />
      <Body />
      <Footer />
    </>
  );
}

export default App;
