//import logo from './logo.svg';
import './App.css';
import{useEffect, useRef, useState} from 'react';

function App() {
  const [kogus, setKogus] = useState(0);
  const [autod,setAutod] = useState([]);
  const nimiRef = useRef();
  const hindRef = useRef();
  const hobuj6udRef = useRef();
  const [autoomanik, setAutoomanik] = useState([]);
  //uef
  
  useEffect(() => {
  fetch("http://localhost:8080/autod")
  .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setAutod(json);
      }) 
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/autoomanik")
    .then(response => response.json())
        .then(json =>{
          setAutoomanik(json);
        }) 

    }, []);

  function kustuta(primaarvoti){
    fetch("http://localhost:8080/autod/" + primaarvoti, {"method":"DELETE"})
    .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setAutod(json);
      })
  }

  
  function kustutaTk(primaarvoti){
    fetch("http://localhost:8080/autoomanik/" + primaarvoti, {"method":"DELETE"})
    .then(response => response.json())
      .then(json =>{
        setAutoomanik(json);
      })
  }
  
  function lisa(){
    const auto = {
    "nimi": nimiRef.current.value,
    "hind": hindRef.current.value,
    "hobuj6ud": hobuj6udRef.current.value,
    
  }
    fetch("http://localhost:8080/autod",  {"method":"POST",
    "body":JSON.stringify(auto),
    "headers":{"Content-Type":"application/json"}})
    .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setAutod(json);
      })
  }
  const AutoRef = useRef();
  const ONimiRef = useRef();

  function lisaTK(){
    const lisatavTK = {
      "auto":{"nimi": AutoRef.current.value},
      "omanikNimi": ONimiRef.current.value
    }
      fetch("http://localhost:8080/autoomanik" ,
       {"method":"POST",
       "body": JSON.stringify(lisatavTK),
       "headers":{"Content-Type":"application/json"}})
      .then(response => response.json())
        .then(json =>{
          setAutoomanik(json);
        })

  }

  return (
    <div className="App">
      mul on{kogus} autosid
      <br/><br/>
      <label > Auto firma</label><br/>
      <input ref={nimiRef} id='nimi' type='text'/> <br/>
      <label > Autohind </label><br/>
      <input ref={hindRef} id='hind' type='text'/> <br/>
      <label> Auto hobujõud</label><br/>
      <input ref={hobuj6udRef} id='hobuj6ud' type='text'/> <br/>
      <button onClick={() => lisa()}>sisesta</button> <br/>
      {autod.map(a => <div>{a.nimi} <button onClick={() => kustuta(a.nimi)}>x</button> </div>)}
<hr />
      <label > auto täpne nimi</label><br/>
      <input ref={AutoRef}  type='text'/> <br/>
      <label > omanik</label><br/>
      <input ref={ONimiRef} type='text'/> <br/>
      <button onClick={() => lisaTK()}>sisesta</button> <br/>
      {autoomanik.map(b => <div>{b.omanikNimi} <button onClick={() => kustutaTk(b.omanikNimi)}>x</button> </div>)}
    </div>
  );
}

export default App;
