
import React from "react";
import logo from '../assets/bookbg.png'
import { Link, Outlet } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useState,useEffect } from "react";
import user_icon from '../assets/person.png';
const Header = () => {
 
  const [customer, setCustomer] = useState({});
  const [cust, setCust] = useState(0);
  useEffect(() => {
    const customerDetails = JSON.parse(sessionStorage.getItem('CustomerLoginDetails'));
    setCust(customerDetails);
  }, []);
 
  
  useEffect(() => {
    if (cust !== 0) {
      fetch(`http://localhost:8080/api/get/${cust}`)
        .then((res) => res.json())
        .then((result) => {
          setCustomer(result);
        });
    }
  }, [cust]);

  const navigate=useNavigate();
  const login = sessionStorage.getItem('isLoggedIn');

  const logout=()=>{ 
    if(sessionStorage.getItem('isLoggedIn')==='true'){
    sessionStorage.setItem('isLoggedIn', false);
    sessionStorage.clear();
        navigate('/');
    }}
 

  return (
    <>

      <header class="py-2 mb-0 ">
        <div class="container d-flex flex-wrap justify-content-center">
          <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
            <img src={logo} alt="" width="50" />
            <span class="fs-4"><b>BOOKWORM</b></span>
          </a>

        </div>
      </header>
      <header class="p-3 text-bg-dark ">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="#" class="nav-link px-2 text-white link-body-emphasis"><Link class="text-white" style={{ textDecoration: 'none' }} to="/Home">Home</Link></a></li>
              <li><a href="#" class="nav-link px-2 text-white"><Link class="text-white" style={{ textDecoration: 'none' }} to="/Products" >Products</Link></a></li>
              <li><a href="#" class="nav-link px-2 text-white"><Link class="text-white" style={{ textDecoration: 'none' }} to="/MyShelf" >MyShelf</Link></a></li>
              <li><a href="#" class="nav-link px-2 text-white"><Link class="text-white" style={{ textDecoration: 'none' }} to="/Cart" >Cart</Link></a></li>
              <li><a href="#" class="nav-link px-2 text-white"><Link class="text-white" style={{ textDecoration: 'none' }} to="/Aboutus">About Us</Link></a></li>
              <li><a href="#" class="nav-link px-2 text-white"><Link class="text-white" style={{ textDecoration: 'none' }} to="/Contactus">Contact Us</Link></a></li>

            </ul>

            <div class="text-end" style={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
              {login === "true" ? (
                <>
                 <img src={user_icon} alt="" style={{ marginRight: '10px' }}/><span style={{ fontWeight: 'bold',marginRight: '20px' }}>Welcome {customer.first_name} {customer.last_name} !    </span>
                <button onClick={logout} class="btn btn-outline-light me-2">
                  <Link style={{ textDecoration: "none" }}>logout</Link>
                </button>
                </>
              ) : (
                <>
                  <button type="button" class="btn btn-outline-light me-2">
                    <Link style={{ textDecoration: "none" }} to="/Login">
                      Login
                    </Link>
                  </button>
                  <button type="button" class="btn btn-outline-light me-2">
                    <Link style={{ textDecoration: "none" }} to="/Signup">
                      Sign up
                    </Link>
                  </button>
                </>
              )}
            </div>
          </div>
        </div>
      </header>
      {/* <Outlet></Outlet> */}
    </>

  );
};

export default Header;
