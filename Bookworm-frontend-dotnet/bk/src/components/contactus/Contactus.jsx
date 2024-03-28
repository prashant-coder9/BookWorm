import React, { useState } from 'react';
import './Contactus.css';
import user_icon from '../assets/person.png';
import email_icon from '../assets/email.png';

const Contactus = () => {
  const [formData, setFormData] = useState({
    Name: '',
    ToEmail: '',
    Message: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("https://localhost:7134/api/SendMail", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log("Email sent successfully");
        alert("Email sent successfully");
      } else {
        console.log('Email not sent');
        alert("Failed to send email. Please try again later.");
      }
    } catch (error) {
      console.error('Error sending email:', error);
      alert("An error occurred while sending the email. Please try again later.");
    }
  };
  

  return (
    <div>
      <div className="signup " style={{ marginBottom: '200px' }}>
        <h2 className="text ">Contact us</h2>
        <div className="underline"></div>
        <form className="inputs" onSubmit={handleSubmit} id="myform">
          <div className="input">
          <img src={user_icon} alt="" />
            <input type="text" placeholder="Name" name="Name" value={formData.Name} onChange={handleChange} />
          </div>

          <div className="input">
          <img src={email_icon} alt="" />
            <input type="email" placeholder="Email" name="ToEmail" value={formData.ToEmail} onChange={handleChange} />
          </div>

          <div className="input">
            <textarea placeholder="Message" name="Message" value={formData.Message} onChange={handleChange} />
          </div>
          <div className="submit-container">
            <button className="submit" type="submit">Submit</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Contactus;
