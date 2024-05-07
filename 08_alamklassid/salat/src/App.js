//import logo from './logo.svg';
import './App.css';
import{useEffect, useRef, useState} from 'react';

function App() {
  const [kogus, setKogus] = useState(0);
  const [toiduained,setToiduained] = useState([]);
  const nimiRef = useRef();
  const valkRef = useRef();
  const rasvRef = useRef();
  const sysivesikRef = useRef();
  const [toidukomponendid, setToidukomponendid] = useState([]);
  //uef
  useEffect(() => {
  fetch("http://localhost:8080/api/toiduained")
  .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setToiduained(json);
      }) 
  }, []);
  useEffect(() => {
    fetch("http://localhost:8080/toidukomponendid")
    .then(response => response.json())
        .then(json =>{
          setToidukomponendid(json);
          
        }) 
    }, []);

  function kustuta(primaarvoti){
    fetch("http://localhost:8080/api/toiduained/" + primaarvoti, {"method":"DELETE"})
    .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setToiduained(json);
      })
  }
  function kustutaTk(primaarvoti){
    fetch("http://localhost:8080/toidukomponendid/" + primaarvoti, {"method":"DELETE"})
    .then(response => response.json())
      .then(json =>{
        setToidukomponendid(json);
        
      })
  }

  //fetch("http://localhost:8080/api/toiduained/" 
  // +nimiref.current.value + "/"
  // + valkref.current.value + "/"...
  
  function lisa(){
    const toiduaine = {
    "nimetus": nimiRef.current.value,
    "valk": valkRef.current.value,
    "rasv": rasvRef.current.value,
    "sysivesik": sysivesikRef.current.value
  }
    fetch("http://localhost:8080/api/toiduained",  {"method":"POST",
    "body":JSON.stringify(toiduaine),
    "headers":{"Content-Type":"application/json"}})
    .then(response => response.json())
      .then(json =>{
        setKogus(json.length);
        setToiduained(json);
      })
  }
  const taNimiRef = useRef();
  const kogusRef = useRef();

  function lisaTK(){
    const lisatavTK = {
      "toiduaine":{"nimetus": taNimiRef.current.value},
      "kogus": kogusRef.current.value
    }
      fetch("http://localhost:8080/toidukomponendid" ,
       {"method":"POST",
       "body": JSON.stringify(lisatavTK),
       "headers":{"Content-Type":"application/json"}})
      .then(response => response.json())
        .then(json =>{
          setToidukomponendid(json);
        })

  }

  return (
    <div className="App">
      mul on{kogus} toiduainet
      <br/><br/>
      <label htmlFor='nimi'> Toiduaine nimi</label><br/>
      <input ref={nimiRef} id='nimi' type='text'/> <br/>
      <label htmlFor='valk'> Toiduaine valk</label><br/>
      <input ref={valkRef} id='valk' type='text'/> <br/>
      <label htmlFor='rasv'> Toiduaine rasv</label><br/>
      <input ref={rasvRef} id='rasv' type='text'/> <br/>
      <label htmlFor='sysivesik'> Toiduaine sysivesik</label><br/>
      <input ref={sysivesikRef} id='sysivesik' type='text'/> <br/>
      <button onClick={() => lisa()}>sisesta</button> <br/>
      {toiduained.map(t => <div>{t.nimetus}| {t.valk} <button onClick={() => kustuta(t.nimetus)}>x</button> </div>)}
<hr />
      <label > toiduaine nimi(täpne nimi)</label><br/>
      <input ref={taNimiRef}  type='text'/> <br/>
      <label > kogus</label><br/>
      <input ref={kogusRef} type='text'/> <br/>
      <button onClick={() => lisaTK()}>sisesta</button> <br/>
      {toidukomponendid.map(tk => <div>{tk.nimetus} <button onClick={() => kustutaTk(tk.nimetus)}>x</button> </div>)}
    </div>
  );
}

export default App;
