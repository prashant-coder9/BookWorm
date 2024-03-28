import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import './display.css';



const Display = ({ book }) => {
   
    
    const[product,setProduct]=useState({});

console.log(product);   
    const {product_id} = useParams();

    useEffect(() =>{
        fetch(`https://localhost:7134/api/Product/id/${product_id}`)
        .then((res) => res.json())
        .then((result) => {
          setProduct(result); console.log(result);
        });
      }, [product_id]);
     
    return (
        <div style={{ marginBottom: '200px' }}>
            <h2 style={{ textAlign: 'center', fontWeight: 'bold',marginBottom: '50px' ,marginTop:'20px'}}>{product.englishName}</h2>
            <div className="product-container">
                <img className="product-image" src={"/BookImages/" + product.name + ".jpg" } style={{ marginLeft: '50px' }}></img>
                <div className="product-details">
                    <h2 style={{ fontWeight: 'bold' }}>{product.englishName}</h2>
                    <p style={{ fontWeight: 'bold' }}>Author: {product?.author}</p>
                    
                    <p style={{fontWeight: 'bold'}}>Description: {product?.descriptionLong}</p>
                    
                
                </div>
            </div>
           
        </div>
    );
   
};

export default Display;

