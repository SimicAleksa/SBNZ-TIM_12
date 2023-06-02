import React, {useState, useEffect} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { BsCheckCircle, BsXCircle } from 'react-icons/bs';
import "../css/vozaceveKazne.css";
import DriverNavbar from '../other/DriverNavbar';



const UserFinesPage = () => {
    const [user, setUser] = useState({vozac: {
      ime: "Nevena",
      prezime: "Radesic",
      racun: "5000"
    },
    kazne: [
      {
        novcanaKazna : "5",
        brojKaznenihBodova: "5",
        duzinaZatvorskeKazne: "5",
        istekla: true,
        vremePlacanja: "fefre"
      }
    ]
  
  });

    useEffect(() => {
      getUserData()
        .then(podaci => setUser(podaci))
        .catch(error => {
          console.error('Error fetching data:', error);
        });
    }, []);


    const getUserData = async () => {
      const response = await fetch('http://localhost:8080/getUserData', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          email: localStorage.getItem("email"),
          sifra: "vf"
        })
      });
      if (response.ok) {
        const podaci = await response.json();
        console.log(podaci)
        return podaci;
      } else {
        throw new Error('Error fetching data');
      }
    };


    const platiKaznu = (id) => {
      platiKaznuBack(id)
    };

    const platiKaznuBack = async (id) => {
      const response = await fetch('http://localhost:8080/platiKaznu', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          id: id,
        })
      });
      if (response.ok) {
        const podaci = await response.json();
        console.log(podaci.id);
        if (podaci.id==="OK")
        {
          toast.success("Kazna je uspjesno placena");
          var millisecondsToWait = 5600;
          setTimeout(function() {
            window.location.reload(false);
          }, millisecondsToWait);


        }
        else
        {
          toast.error("Nemate dovoljno novca na racunu");
        }
        return podaci;
      } else {
        throw new Error('Error fetching data');
      }
    };
  

  
    return (
      <div>
        <div style={{position: 'fixed', width: '100%', top: '0px'}}>
      <DriverNavbar/>
      <ToastContainer />
      </div>
      <div id="backgroundDiv-vozac">
        <div style={{ width: '65%', margin: '0 auto', marginTop: '60px'}} id='outerDiv' class='shadow'>
        <h1>{user.vozac.ime} {user.vozac.prezime}</h1>
        <div className="account-info">My account: {user.vozac.racun}$</div>
  
        <div className="fine-list">
          {user.kazne.map((fine) => (
            <div className="fine-item-vozac" key={fine.id}>
              <div className="row">
                <div className="col-md-4">
                <label>Datum: <b>{fine.datum}</b></label>
                </div>
              </div>
              <div className="row">
                <div className="col-md-4">Novcani iznos: <b>{fine.novcanaKazna} </b>RSD</div>
                <div className="col-md-3">Kazneni poeni: <b>{fine.brojKaznenihBodova}</b></div>
                <div className="col-md-5">Duzina zatvorske kazne: <b>{fine.duzinaZatvorskeKazne}</b></div>
              </div>
              <div className="row">
                <div className="col-md-4">
                <label> Kazna je placena: </label>
                    {fine.vremePlacanja || fine.novcanaKazna==0 ? <BsCheckCircle className="icon-positive" /> : <BsXCircle className="icon-negative" />}
                </div>
                <div className="col-md-4">
                <label>Kazna je aktivna: </label>
                    {!fine.istekla ? <BsCheckCircle className="icon-positive"/> : 
                    <BsXCircle className="icon-negative" />}
                </div>
              </div>
              <div className="row">
                <div className="col-md-12 text-right">
                {fine.vremePlacanja ? null : <button className="btn btn-primary" onClick={() => platiKaznu(fine.id)}>Pay</button>}
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
    </div>
    );
  };
  
  export default UserFinesPage;