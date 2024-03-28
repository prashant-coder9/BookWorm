import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './display.css';



const Display = ({ book }) => {
    const [selectedBook, setSelectedBook] = useState(null);
    
    const[product,setProduct]=useState({});


    const {product_id} = useParams();

    useEffect(() =>{
        fetch(`http://localhost:8080/api/products/getProduct/${product_id}`)
        .then((res) => res.json())
        .then((result) => {
          setProduct(result); console.log(result);
        });
      }, []);
     
    return (
        <div style={{ marginBottom: '200px' }}>
            <h2 style={{ textAlign: 'center', fontWeight: 'bold',marginBottom: '50px' ,marginTop:'20px'}}>{product.product_english_name}</h2>
            <div className="product-container">
                <img className="product-image" src={"/BookImages/" + product.product_name + ".jpg"} ></img>
                <div className="product-details">
                    <h2 style={{ fontWeight: 'bold' }}>{product.product_english_name}</h2>
                    <p style={{ fontWeight: 'bold' }}>Author: {product?.product_author}</p>
                    <p style={{ fontWeight: 'bold' }}>Genre: {product?.product_genre?.genreDesc}</p>
                    <p style={{ fontWeight: 'bold' }}>Description: {product?.product_description_long}</p>
                    
                
                </div>
            </div>
           
        </div>
    );
   
};

export default Display;

