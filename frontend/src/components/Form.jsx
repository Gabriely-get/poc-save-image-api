import React, { useState } from 'react';
import axios from 'axios';

import FileToBase64 from 'react-file-base64';

const Form = () => {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [nome, setNome] = useState('');
  const [image, setImage] = useState(null);
  const [base64ImageData, setBase64ImageData] = useState('');
  const [message, setMessage] = useState('');

  const handleEmailChange = (event) => {
    setMessage(false);
    setEmail(event.target.value);
  };

  const handleSenhaChange = (event) => {
    setSenha(event.target.value);
  };

  const handleNomeChange = (event) => {
    setNome(event.target.value);
  };

  const handleSubmit = async (event) => {
    setMessage(false);
    event.preventDefault();


    const formData = {
        nome: nome,
        email: email,
        senha: senha,
        image: base64ImageData.base64,
      };
  
      try {
        const response = await axios.post('http://localhost:8080/user/register', formData, {
            headers: {
              'Content-Type': 'application/json',
            },
          });

        if (response.status == 201) {
          console.log('Form submitted successfully:', response.data);
          setNome('');
          setEmail('');
          setSenha('');
          setBase64ImageData('');
          setMessage(true);
        } 
      } catch (error) {
        console.error('Failed to submit form:', error);
      }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>Nome:</label>
        <input type="nome" value={nome} onChange={handleNomeChange} />
        <br /><br />

        <label>Email:</label>
        <input type="email" value={email} onChange={handleEmailChange} />
        <br /><br />

        <label>Senha:</label>
        <input type="password" value={senha} onChange={handleSenhaChange} />
        <br /><br />

        <label>Image:</label>
        <br />

        <FileToBase64
            value={image}
            onDone={(base64Data) => {
                setBase64ImageData(base64Data);
            }}
        />
        <br /><br />

        <button type="submit">Submit</button>
      </form>

      <br />
      {(message == true && "Form submitted successfully") || (message == false && "Try to register an user ;)")}
    </div>
    
  );
};

export default Form;
