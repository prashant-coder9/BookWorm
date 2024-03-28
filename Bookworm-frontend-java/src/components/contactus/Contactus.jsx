import React, { useState } from 'react';
import './Contactus.css';
import user_icon from '../assets/person.png';
import email_icon from '../assets/email.png';


const Contactus = () => {
  const [formData, setFormData] = useState({
    name: '',
    recipient: '',
    msgBody: '',
    
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/sendMail', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      }).then((response)=>{
          if(response.ok){
              console.log("email sent successfully");
              alert("Email sent successfully");
          }else{
              console.log('email not sent');
              alert("Failed to send email. Please try again later.");
          }
      });
  }catch(e){
    console.log(e);
    alert("An error occurred while sending the email. Please try again later.");
  }
}

  return (
    <div>
    <div className="signup " style={{ marginBottom: '200px' }}> 
      <h2 className="text ">Contact us</h2> 
      <div className="underline"></div>
      
      <form className="inputs" onSubmit={handleSubmit} id="myform"> 
        <div className="input"> 
        <img src={user_icon} alt="" />
          <input type="text" placeholder="Name" name="name" value={formData.name} onChange={handleChange}/> 
        </div> 
       
        <div className="input">
          <img src={email_icon} alt="" />
          <input type="email" placeholder="Email" name="recipient" value={formData.email} onChange={handleChange}/> 
        </div> 
        
        <div className="input">
          <textarea placeholder="Message" name="msgBody" value={formData.message} onChange={handleChange}/> 
        </div> 
        <div className="submit-container">
            <button className="submit" type="submit">Submit</button>
        </div> 
      </form> 
    </div> 
    </div>
  );
  }
export default Contactus;

