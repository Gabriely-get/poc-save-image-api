import React, { useState } from 'react';
import DetailUser from "./components/DetailUser";
import ImageList from "./components/ImageList";
import Form from "./components/Form";

const App = () => {
  const [activeComponent, setActiveComponent] = useState('');

  return (
    <div>
      <button onClick={() => setActiveComponent('Form')}>Cadastrar usuário</button>
      <br/> <br/>
      <button onClick={() => setActiveComponent('DetailUser')}>Detalhar usuário</button>
      <br/> <br/>
      <button onClick={() => setActiveComponent('ImageList')}>Listar imagens</button>
      <br/> <br/>
      <button onClick={() => setActiveComponent('')}>Limpar Home</button>
      <br/> <br/>

      {activeComponent === 'Form' && <Form />}
      {activeComponent === 'DetailUser' && <DetailUser />}
      {activeComponent === 'ImageList' && <ImageList />}
    </div>
  );
};

export default App;