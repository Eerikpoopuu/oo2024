//import logo from './logo.svg';
import './App.css';
import{useEffect, useRef, useState} from 'react';

function App() {
  const [kogus, setKogus] = useState(0);
  const [autod,setAutod] = useState([]);
  const markRef = useRef();
  const pikkusRef = useRef();
  const massRef = useRef();
  const aastaRef = useRef();
  //uef
  
  useEffect(() => {
  fetch("http://localhost:8080/autod")
  .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setAutod(json);
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
  function lisa(){
    const auto = {
    "mark": markRef.current.value,
    "pikkus": pikkusRef.current.value,
    "mass": massRef.current.value,
    "aasta": aastaRef.current.value
    
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

  return (
    <div className="App">
      mul on{kogus} autosid
      <br/><br/>
      <label > Auto mark</label><br/>
      <input ref={markRef} id='mark' type='text'/> <br/>
      <label > Auto Pikkus </label><br/>
      <input ref={pikkusRef} id='pikkus' type='text'/> <br/>
      <label> Auto mass</label><br/>
      <input ref={massRef} id='mass' type='text'/> <br/>
      <label> Auto aasta</label><br/>
      <input ref={aastaRef} id='aasta' type='text'/> <br/>
      <button onClick={() => lisa()}>sisesta</button> <br/>
      {autod.map(a => <div>{a.mark} <button onClick={() => kustuta(a.id)}>x</button> </div>)}
    </div>
  );
}

export default App;

