import React, { useState, useEffect } from 'react';
import axios from 'axios';

//MOSTRA TODAS AS IMAGENS -> GET ALL IMAGES

const ImageList = () => {
  const [images, setImages] = useState([]);

  useEffect(() => {

    const fetchImages = async () => {
      const response = await axios.get('http://localhost:8080/images/');

      setImages(response.data);
    };

    fetchImages();
  }, []);

  return (
    <div>
      {images.map((image) => (
        <img src={image} alt="Image" key={image} />
      ))}
    </div>
  );
};

export default ImageList;
