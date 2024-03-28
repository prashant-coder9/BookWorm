import React, { useState,useEffect } from 'react';
import './MyShelf.css';
const MyShelf = () => {
  const [updateProduct,setupdateProduct]=useState([]);
  const [cust, setCust] = useState(0);
  const [expiredProducts, setExpiredProducts] = useState([]);
  const [showExpired,setshowExpired]=useState(false);
  const [updateExpried,setUpdateExpried]=useState([])

  useEffect(() => {
    const customerDetails = JSON.parse(sessionStorage.getItem('CustomerLoginDetails'));
    setCust(customerDetails);
  }, []);
  const deleteProducts = () => {
      if (cust !== 0) {
        fetch(`https://localhost:7134/api/MyShelf/${cust}`)
          .then((res) => res.json())
          .then((result) => {
            checkExpiryDates(result);
            setshowExpired(true);
          });
        }
        const checkExpiryDates = (products) => {
          const currentDate = new Date();
          const expiredProducts = products.filter(product => {
            const productExpiryDate = new Date(product.productExpiryDate);
            return product.productExpiryDate && productExpiryDate < currentDate;
          });
          setExpiredProducts(expiredProducts);
          setUpdateExpried(expiredProducts);
          expiredProducts.forEach(product => {
            fetch(`https://localhost:7134/api/MyShelf/${product.buyId}`, {
              method: 'DELETE',
            })
            .then(response => response.json())
            .then((data)=>{
              console.log(data);    
            })
            .catch((error) => console.error('Error:', error));
          });
        };
       
  };
  const getProducts=()=>{
    if (cust !== 0) {
      fetch(`https://localhost:7134/api/MyShelf/${cust}`)
        .then((res) => res.json())
        .then((result) => {
          setupdateProduct(result);
          setshowExpired(false);
        });
      }
  }
  return (
    <div style={{ marginBottom: '400px' }}>
      <button onClick={() => deleteProducts()}>Expired Product</button>
      <button onClick={() => getProducts()}>Get Buyed/Rented Products</button>

      {showExpired ? (
      expiredProducts.length > 0 && (
        <div>
          <h2>Expired Products:</h2>
          {updateExpried.map((product) => (
            <p key={product.shelfId}>Product {product.productName} has expired on date {product.productExpiryDate}</p>
          ))}
        </div>
      )
    ) : (
      <table >
        <thead>
          <tr>
            <th>ProductID</th>
            <th>ProductExpiryDate</th>
            <th>productName</th>
            <th>BuyAmount</th>
            <th>ProductRentAmount</th>
          </tr>
        </thead>
        <tbody>
          {updateProduct.map((product) => (
            <tr key={product.shelfId}>
              <td>{product.buyId}</td>
              <td>{product.productExpiryDate}</td>
              <td>{product.productName}</td>
              <td>{product.priceAmount}</td>
              <td>{product.totalAmount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    )}
    </div>
  );
};

export default MyShelf;