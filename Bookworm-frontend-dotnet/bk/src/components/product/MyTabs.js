import Language from './Language'
import MyCard from './MyCard';
import { useEffect, useState } from 'react'
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';

export default function Products () {
  const [productType, setProductType] = useState([]);
  const [selectedLanguage, setSelectedLanguage] = useState(null);
  const [selectedGenre, setSelectedGenre] = useState(null);
  useEffect(() =>{
    fetch("https://localhost:7134/api/ProductType/getAll")
    .then((res) => res.json())
    .then((result) => {
      setProductType(result);
    });
  }, []);
console.log(productType);
  return (
    <Tabs
        defaultActiveKey="1"
        id="justify-tab-example"
        className="mb-3"
        justify
    >
        {productType.map((val) => (
            <Tab eventKey={val.typeId} title={val.typeDesc}>
                <div>
            <Language setSelectedLanguage={setSelectedLanguage}  setSelectedGenre={setSelectedGenre}/>
            <MyCard typeId={val.typeId} selectedLanguage={selectedLanguage} selectedGenre={selectedGenre}/>
          </div>
            </Tab>
        ))}
    </Tabs>
    
);
}