import React from "react";
import "./login.css";
import { useState } from "react";
import email_icon from "../assets/email.png";
import password_icon from "../assets/password.png";
import { useNavigate } from "react-router-dom";
export const Login = () => {
  let navigate=useNavigate();
  const [loginDetails, setLogInDetails] = useState({});
  // let navigate=useNavigate();
  const handleChange = (event) => {
    setLogInDetails((values) => ({ ...values, [event.target.name]: event.target.value }));
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    let details = JSON.stringify(loginDetails);
    fetch("https://localhost:7134/api/Customer/Login", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: details,
    }).then((response)=>{
      console.log(response);
     return response.json();
    })
  .then((result) => {
    console.log("Response:", result);
    console.log("Type of response:", typeof result);
    if (result.customerId) {
      sessionStorage.setItem('CustomerLoginDetails',result.customerId); 
      sessionStorage.setItem('isLoggedIn',true)
      console.log(sessionStorage.getItem('isLoggedIn'))
        alert("Login Success!!"); 
       navigate("/");
    } else {
        console.log("Login failed!");
        alert("Login Failed!!");
    }
});
   
  };
  return (
    
      <div className="signup" style={{ marginBottom: '200px' }}>
        <div classname="header">
          <div className="text">LOGIN</div>
          <div className="underline"></div>
        </div>
        <form className="inputs" onSubmit={handleSubmit}>
          <div className="input">
            <img src={email_icon} alt="" />
            <input type="email" placeholder="Email Id" name="email" onChange={handleChange} />
          </div>
          <div className="input">
            <img src={password_icon} alt="" />
            <input type="password" placeholder="Password" name="password" onChange={handleChange} />
          </div>
          <div className="forgot-password">
            Forgot Password?<span>Click Here!</span> 
          </div>
          <div className="submit-container">
          <input type="submit" value="LogIn" className="submit" />
          <button onClick={() => navigate("/signup")} className="submit">SignUp</button>
          </div>
        </form>
      </div>
    
  );
};
