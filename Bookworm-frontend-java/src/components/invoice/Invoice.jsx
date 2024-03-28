import React from "react";
import { useEffect, useState } from 'react'
import {
  MDBCard,
  MDBCardBody,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBBtn,
  MDBIcon,
  MDBTypography,
  MDBTable,
  MDBTableHead,
  MDBTableBody,
} from "mdb-react-ui-kit";
export default function Invoice() {
  const [getInvoice, setGetInvoice] = useState([]);
  const [customer, setCustomer] = useState({});
  const [cust, setCust] = useState(0);
  //const [getInvoice, setGetInvoice] = useState([]);

  useEffect(() => {
    const customerDetails = JSON.parse(sessionStorage.getItem('CustomerLoginDetails'));
    setCust(customerDetails);
  }, []);

  useEffect(() => {
    if (cust !== 0) {
    fetch(`http://localhost:8080/ByCustomerId/${cust}`)
      .then((res) => res.json())
      .then((result) => {
        setGetInvoice(result);
        // console.log(result);
      });
    }
  }, [cust]);

  useEffect(() => {
    if (cust !== 0) {
      fetch(`http://localhost:8080/api/get/${cust}`)
        .then((res) => res.json())
        .then((result) => {
          setCustomer(result);
        });
    }
  }, [cust]);



  const totalPrice = () => {
    return getInvoice.reduce((total, pro) => total + pro.buyAmount+pro.rentAmount, 0);
  };

  const handlePrint = () => {
    window.print();
  };
  return (
    <MDBContainer className="py-5" style={{ marginBottom: '100px' }}>
      <MDBCard className="p-4">
        <MDBCardBody>
          <MDBContainer className="mb-2 mt-3">
            <MDBRow className="d-flex align-items-baseline">
              <MDBCol xl="9">
                <p style={{ color: "#7e8d9f", fontSize: "20px" }}>
                  
                </p>
              </MDBCol>
              <MDBCol xl="3" className="float-end">
                <MDBBtn
                  color="light"
                  ripple="dark"
                  className="text-capitalize border-0"
                  onClick={handlePrint}
                >
                  <MDBIcon fas icon="print" color="primary" className="me-1" />
                  Print
                </MDBBtn>
                
                <hr />
              </MDBCol>
            </MDBRow>
          </MDBContainer>
          <MDBContainer>
            <MDBCol md="12" className="text-center">
              <h1 className="pt-0">BOOKWORM</h1>
              <p className="pt-0">bookworm.com</p>
            </MDBCol>
          </MDBContainer>
          <MDBRow>
            <MDBCol xl="8">
              <MDBTypography listUnStyled>
                <li className="text-muted">
                  To: <span style={{ color: "#5d9fc5" }}>{customer.first_name} {customer.last_name}</span>
                </li>
                <li className="text-muted">{customer.city}</li>
                <li className="text-muted">{customer.country}</li>
                <li className="text-muted">
                  
                </li>
              </MDBTypography>
            </MDBCol>
            <MDBCol xl="4">
              <p className="text-muted">Invoice</p>
              <MDBTypography listUnStyled>
                <li className="text-muted">
                 
                </li>
                <li className="text-muted">
                  <MDBIcon fas icon="circle" style={{ color: "#84B0CA" }} />
                  <span className="fw-bold ms-1">Creation Date: </span>{new Date().toLocaleDateString()}
                </li>
              </MDBTypography>
            </MDBCol>
          </MDBRow>
          <MDBRow className="my-2 mx-1 justify-content-center">
            <MDBTable striped borderless>
              <MDBTableHead
                className="text-white"
                style={{ backgroundColor: "#84B0CA" }}
              >
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Description</th>
                  <th scope="col">Qty</th>
                  <th scope="col">Unit Price</th>
                  <th scope="col">BuyAmount</th>
                  <th scope="col">RentAmount</th>
                </tr>
              </MDBTableHead>
              <MDBTableBody>
              {getInvoice.map((pro) => {
                //console.log(pro);
                return (
                <tr key={pro.invoiceId}>
                  <th scope="row">{pro.productId}</th>
                  <td>{pro.productName}</td>
                  <td>{1}</td>
                  <td>₹{pro.buyAmount}</td>
                  <td>₹{pro.buyAmount}</td>
                  <td>₹{pro.rentAmount}</td>
                </tr>
                );
})}
                
              </MDBTableBody>
            </MDBTable>
          </MDBRow>
          <MDBRow>
            <MDBCol xl="8">
              
            </MDBCol>
            <MDBCol xl="3">
              <MDBTypography listUnStyled>
                <li className="text-muted ms-3">
                  <span class="text-black me-4">SubTotal</span>₹{totalPrice().toFixed(2)}
                </li>
                <li className="text-muted ms-3 mt-2">
                  <span class="text-black me-4">Tax(15%)</span>₹{(totalPrice()* 0.15).toFixed(2)}
                </li>
              </MDBTypography>
              <p className="text-black float-start">
                <span className="text-black me-3"> Total Amount</span>
                <span style={{ fontSize: "25px" }}>₹{(totalPrice()* 1.15).toFixed(0)}</span>
              </p>
            </MDBCol>
          </MDBRow>
          <hr />
          <MDBRow>
            <MDBCol xl="10">
              <p>Thank you for your purchase</p>
            </MDBCol>
            <MDBCol xl="2">
              {/* { <MDBBtn
                className="text-capitalize"
                style={{ backgroundColor: "#60bdf3" }}
                onClick={show}
              >
                Pay Now
              </MDBBtn> } */}
            </MDBCol>
          </MDBRow>
        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
    
  );
}
