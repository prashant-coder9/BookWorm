import React, { useEffect, useState } from 'react'
import { Button, Card, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
// import './Mycard.css';


export default function MyCard({typeId,selectedLanguage,selectedGenre}) {
    const [products, setProducts] = useState([]);
    const [showRentForm, setShowRentForm] = useState(false);
    const [selectedProduct, setSelectedProduct] = useState(null);
    const [rentAmount, setRentAmount] = useState(0);
    const [numberOfDays, setNumberOfDays] = useState(0);
    const [totalAmount, setTotalAmount] = useState(0);
    const [addedToCart, setAddedToCart] = useState([]);
    const [minRentDay, setMinRentDays] = useState(0);
      let navigate=useNavigate();
    //  console.log(typeId+" "+selectedLanguage+" "+selectedGenre );
    useEffect(() => {
      //  console.log('hello')
        if (typeId!=null&&selectedLanguage == null&&selectedGenre==null) {
            fetch(`http://localhost:8080/api/products/getProductsByType/${typeId}`)
            .then((res) => res.json())
            .then((data) => setProducts(data))
        } 
        if(typeId!=null&&selectedLanguage != null&&selectedGenre==null){
            fetch(`http://localhost:8080/api/products/getProductsByTypeandLang/${typeId}/${selectedLanguage}`)
                .then((res) => res.json())
                .then((data) => setProducts(data));
        } 
        if(typeId!=null&&selectedLanguage != null&&selectedGenre!=null){
          fetch(`http://localhost:8080/api/products/getProductsBytypeandgenre/${typeId}/${selectedLanguage}/${selectedGenre}`)
          .then((res) => res.json())
          .then((data) => setProducts(data));
        }
  }, [typeId, selectedLanguage,selectedGenre]);
    useEffect(() => {
      const login = sessionStorage.getItem("isLoggedIn");
      if (login === null) {
          sessionStorage.setItem("isLoggedIn", false);
      }
  }, []);
const Buy = (product) => {
  const login = JSON.parse(sessionStorage.getItem("isLoggedIn"));
  if(login){
  if (addedToCart.includes(product.product_id)) {
    alert('This product is already in your cart.');
  }
  else{
  const details = {
    book_id: product.product_id,
    book_name: product.product_name,
    price: product.product_offerprice,
    purchaseType: "buy"
  };
  setAddedToCart([...addedToCart, product.product_id]);
  // Get existing products from session storage
  let existingProducts = sessionStorage.getItem("buydetails");
  existingProducts = existingProducts ? JSON.parse(existingProducts) : [];

  // Add new product to existing products
  existingProducts.push(details);

  // Save updated products back to session storage
  sessionStorage.setItem("buydetails", JSON.stringify(existingProducts));
  alert('This product is successfully added in your cart.');
}
}
else{
   navigate("/Login");
}
}
const Rent = (product) => {
  const login = JSON.parse(sessionStorage.getItem("isLoggedIn"));
  if(login){
  if (addedToCart.includes(product.product_id)) {
    alert('This product is already in your cart. You cannot rent it.');
  }
  else if (window.confirm('Are you sure you want to confirm your order?')) {
    setSelectedProduct(product);
  setShowRentForm(true);
  setRentAmount(product.rent_per_day); 
  setMinRentDays(product.min_rent_days);// Set rental amount from product data
  calculateTotalAmount(numberOfDays); // Set total amount initially for 1 day
  setAddedToCart([...addedToCart, product.product_id]);
}
}
else{
  navigate("/Login");
}
}
const handleSubmitRent = () => {
  if(numberOfDays<minRentDay||numberOfDays===0) {    
    alert("enter "+selectedProduct.min_rent_days+" minimum day to rent the"+selectedProduct.product_name+" book:");
  } else {
    const details = {
      book_id: selectedProduct.product_id,
      book_name: selectedProduct.product_name,
      no:numberOfDays,
      purchaseType: "rent",
      totalAmount: totalAmount
    };

    // Get existing products from session storage
    let existingProducts = sessionStorage.getItem("rentdetails");
    existingProducts = existingProducts ? JSON.parse(existingProducts) : [];

    // Add new product to existing products
    existingProducts.push(details);

    // Save updated products back to session storage
    sessionStorage.setItem("rentdetails", JSON.stringify(existingProducts));

    alert(`Item added to cart successfully! Rental amount: ${rentAmount}, Total amount: ${totalAmount}`);
    setShowRentForm(false);
  }
};
    
      const calculateTotalAmount = (days) => {
        const total = rentAmount * days;
        setTotalAmount(total);
      };
    
      const handleCloseRentForm = () =>{ 
        setShowRentForm(false);
      };
      const onChangeNumberDay=(e)=>{
        setNumberOfDays(e.target.value)
        calculateTotalAmount(e.target.value);
      }
      const goPage = (product_id)=>{
        navigate(`/product/${product_id}`);
    }

    return (
        <div style={{ marginBottom: '50px' }}>
        
        {showRentForm && (
        <div className="popup" style={{ marginBottom: '50px',marginTop:'20px',marginLeft:'40px' }}>
          <div className="popup-content">
            <span className="close" onClick={handleCloseRentForm}>&times;</span>
            <h3>Rent Product</h3>
            <p>Product: {selectedProduct.product_name}</p>
            <label htmlFor="numberOfDays">Number of days:</label>
            <input type="number" id="numberOfDays" value={numberOfDays} onChange={onChangeNumberDay}/>
            <label htmlFor="rentAmount">Rental amount:</label>
            <input type="text" id="rentAmount" value={rentAmount} readOnly />
            <label htmlFor="totalAmount">Total amount:</label>
            <input type="text" id="totalAmount" value={totalAmount} readOnly />
            <button onClick={handleSubmitRent}>Rent</button>
          </div>
        </div>
      )}
      <Container className='d-flex align-items-center py-5 row row-cols-1 row row-cols-sm-2 row row-cols-md-3 justify-content-start' fluid='sm'>
            {
                products.map((product) => (
                    <Card style={{ width: '18rem' }} className='mx-3 my-2 flex'>
                          <div style={{ display: 'flex', justifyContent: 'center' }}> {/* Add this line */}

                        <Card.Img style = {{width: 220, height: 300}} variant="top" src={"/BookImages/" + product.product_name + ".jpg"} />
                        </div>
                        <Card.Body>
                            <Card.Title>{product.product_name}</Card.Title>
                            <Card.Text>{product.product_description_short}</Card.Text>
                            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                           <Card.Text style={{textDecoration: 'line-through' }}> Rs.{product.product_baseprice}</Card.Text>
                            <Card.Text>Rs.{product.product_offerprice}</Card.Text>
                            </div>
                            <Button  variant="primary" onClick={() => Buy(product)}>Add to Cart</Button>
                            <Button className="ml-1" variant="primary" onClick={() => Rent(product)}>rent</Button>
                            <Button variant="primary" onClick={()=>goPage(product.product_id)} >View Details</Button>
                        </Card.Body>
                    </Card>))

            }
        </Container>
        
        </div>
  );
}