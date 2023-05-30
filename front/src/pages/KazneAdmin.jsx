import React, {useState, useEffect} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import "../css/kazne.css";
import { BsCheckCircle, BsXCircle } from 'react-icons/bs';
import AdminNavbar from '../other/AdminNavbar';




//export default function PodaciSaRadara() {
  const KazneAdminPage = () => {
    const [filters, setFilters] = useState({
      carRegistrationNumber: '',
      driverLicenseNumber: '',
      fine: '',
      penaltyPoints: '',
      prisonSentence: '',
      startDate: '',
      endDate: '',
      isPaid: '',
      isActive: ''
    });
  
    const [fines, setFines] = useState([]);
    const [isfilrirano, setIsfiltrirano] = useState([]);

     useEffect(() => {
      getKazne()
        .then(podaci => setFines(podaci))
        .catch(error => {
          console.error('Error fetching data:', error);
        });
        getKazne()
      .then(podaci => setIsfiltrirano(podaci))
      .catch(error => {
        console.error('Error fetching data:', error);
      });
    }, []);

    const getKazne = async () => {
      const response = await fetch('http://localhost:8080/getKazne', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        }
      });
      if (response.ok) {
        const podaci = await response.json();
        return podaci;
      } else {
        throw new Error('Error fetching data');
      }
    };
  
    const handleFilterChange = (e) => {
      const { name, value } = e.target;
      setFilters((prevFilters) => ({
        ...prevFilters,
        [name]: value
      }));
    };
  
    
  const handleFilterSubmit = (e) => {
    e.preventDefault();
    let retVal = [];
    for (let i of fines)
    {
      if ((filters.carRegistrationNumber && i.registarskiBrojVozila.includes(filters.carRegistrationNumber)) || (!filters.carRegistrationNumber)) 
      {
        if ((filters.driverLicenseNumber && i.brojVozackeDozvole.includes(filters.driverLicenseNumber)) || (!filters.driverLicenseNumber)) 
      {
        if ((i.novcanaKazna== filters.fine) || (filters.fine==="")) 
        {
          if ((i.brojKaznenihBodova== filters.penaltyPoints) || (filters.penaltyPoints==="")) 
          {
            if ((i.duzinaZatvorskeKazne== filters.prisonSentence) || (filters.prisonSentence==="")) 
            {
              if ((!filters.startDate) || (filters.startDate <= i.datum)) 
            {
                if ((!filters.endDate) || (filters.endDate >= i.datum)) 
                {
                  if (filters.isActive==="" || (filters.isActive==="true" && i.istekla===false)
                || (filters.isActive==="false" && i.istekla===true)) 
                  {
                    if (filters.isPaid==="" || (filters.isPaid==="true" && i.vremePlacanja)
                    || (filters.isPaid==="false" && !i.vremePlacanja)) 
                      {
                      retVal.push(i);
                    }    
                }      
              }         
            }      
            }          
          }
       }
      }
      }
    }
    setIsfiltrirano(retVal);
    
  };


    return (
      <div>
      <div style={{position: 'fixed', width: '100%', top: '0px'}}>
      <AdminNavbar/>
      </div>

      <div id="backgroundDiv">
      <div style={{ width: '50%', margin: '0 auto'}} id='outerDiv' class='shadow'>
      <form class="mb-3"  onSubmit={handleFilterSubmit}>
        <div class="row">
          <div class="col-md-6">
            <label>Registarski broj vozila:</label>
            <input class="form-control" type="text" name="carRegistrationNumber" value={filters.carRegistrationNumber} onChange={handleFilterChange}/>
          </div>
          <div class="col-md-6">
            <label>Broj vozacke dozvole:</label>
            <input class="form-control" type="text" name="driverLicenseNumber" value={filters.driverLicenseNumber} onChange={handleFilterChange} />
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label>Visina novcane kazne:</label>
            <input class="form-control" type="number" name="fine" value={filters.fine} onChange={handleFilterChange}/>
          </div>
          <div class="col-md-4">
            <label>Kazneni poeni:</label>
            <input class="form-control" type="number" name="penaltyPoints" value={filters.penaltyPoints} onChange={handleFilterChange}/>
          </div>
          <div class="col-md-4">
            <label>Duzina zatvorske kazne:</label>
            <input class="form-control" type="number" name="prisonSentence" value={filters.prisonSentence} onChange={handleFilterChange}/>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <label>Datum - od:</label>
            <input class="form-control" type="date" name="startDate" value={filters.startDate} onChange={handleFilterChange}/>
          </div>
          <div class="col-md-6">
            <label>Datum - do:</label>
            <input class="form-control" type="date" name="endDate" value={filters.endDate} onChange={handleFilterChange}/>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label>Kazna je placena:</label>
            <select class="form-control" name="isPaid" value={filters.isPaid} onChange={handleFilterChange}>
              <option value="">Sve</option>
              <option value="true">Placene</option>
              <option value="false">Neplacene</option>
            </select>
          </div>
          <div class="col-md-4">
            <label>Kazna je aktivna:</label>
            <select class="form-control" name="isActive" value={filters.isActive} onChange={handleFilterChange}>
              <option value="">Sve</option>
              <option value="true">Aktivne</option>
              <option value="false">Neaktivne</option>
            </select>
          </div>
          <div class="col-md-4 mt-4 mr-0">
            <button type="submit" class="btn btn-primary">Filter</button>
          </div>
        </div>
      </form>
      <hr></hr>


      <div className="fines-list">
  {isfilrirano.map((fine, index) => (
    <div className="fine-item rounded" key={index} class="shadow mb-3 mt-2 bg-light">
      <div className="fine-row" class='row'>
        <div className="attribute" class="col-md-6">
          <label>Registarski broj vozila: <b> {fine.registarskiBrojVozila}</b></label>
        </div>
        <div className="attribute" class="col-md-6">
          <label>Broj vozacke dozvole:<b> {fine.brojVozackeDozvole}</b></label>   
        </div>
      </div>
      <div className="fine-row">
        <div className="attribute" class="col-md-4">
          <label>Visina novcane kazne:<b>{fine.novcanaKazna}</b></label>
        </div>
        <div className="attribute" class="col-md-4">
          <label>Kazneni poeni:<b>{fine.brojKaznenihBodova}</b></label>
          
        </div>
        <div className="attribute" class="col-md-4">
          <label>Duzina zatvorske kazne:<b>{fine.duzinaZatvorskeKazne}</b></label>
        </div>
      </div>
      <div className="fine-row">
        <div className="attribute" class="col-md-4">
          <label>Datum: <b>{fine.datum}</b></label>
        </div>
        <div className="attribute" class="col-md-4">
        <label>Kazna je placena: </label>
        {fine.vremePlacanja || fine.novcanaKazna == 0 ? <BsCheckCircle className="icon-positive" /> : <BsXCircle className="icon-negative" />}
      </div>
      <div className="attribute" class="col-md-4">
        <label>Kazna je aktivna: </label>
        {!fine.istekla ? <BsCheckCircle className="icon-positive"/> : 
        <BsXCircle className="icon-negative" />}
      </div>
      </div>
      <hr></hr>
    </div>
    
  ))}

    </div>
    </div>
    </div>
    </div>
    );
  };

export default KazneAdminPage;