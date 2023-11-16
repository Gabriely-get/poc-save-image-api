import React, { useState } from 'react';
import axios from 'axios';

const DetailUser = () => {
    const [image, setImage] = useState('');
    const [userId, setUserId] = useState('');
    const [id, setId] = useState('');
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    const handleDetails = async () => {
        const response = await axios.get('http://localhost:8080/user/'+userId);

        setImage(response.data.image);
        setId(response.data.id);
        setEmail(response.data.email);
        setNome(response.data.nome);

    };

    return (
        <div>
            
            Digite o id do usuario: 
            <input type="number" name="userId" id="" onChange={e => setUserId(e.target.value)}/>
            <br /><br />
            <button onClick={handleDetails}>Submit</button>


            {id && <p>Id: {id}</p>} <br/>
            {nome && <p>Nome: {nome}</p>} <br/>
            {email && <p>E-mail: {email}</p>} <br/>
            {image && <img src={image} alt="Image" />}
        </div>
    );
};

export default DetailUser;


/* FOR DECODE A BASE64 IMAGE
function base64Decode(base64String) {
    let binaryString = window.atob(base64String);
    let bytes = new Uint8Array(binaryString.length);
    for (let i = 0; i < bytes.length; i++) {
        bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes;

    -> for fetch image
    const base64ImageData = response.data.image;
    const decodedBytes = base64Decode(base64ImageData);
    const imageBlob = new Blob([decodedBytes], { type: 'image/png' });
    const imageUrl = URL.createObjectURL(imageBlob);
}

*/