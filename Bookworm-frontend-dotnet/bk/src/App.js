import React from "react";
import Header from "./components/Header/Header";
import "./style.css"; // Import your CSS file
import Footer from "./components/Footer/Footer";
import HeaderLogin from "./components/Header/Headern";
import Home from "./components/Home/Home";
import { Outlet } from "react-router-dom";

const App = () => {
  return (
    <>
      <Outlet></Outlet>
    </>
  );
};

export default App;
