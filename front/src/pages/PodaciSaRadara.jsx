import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import AdminNavbar from '../other/AdminNavbar';

const TrafficDataPage = () => {
  const [filters, setFilters] = useState({
    location: '',
    weatherCondition: '',
    carRegistrationNumber: '',
    locationType: '',
    speedLimitFrom: '',
    speedLimitTo: '',
    detectedSpeedFrom: '',
    detectedSpeedTo: ''
  });

  const [data, setData] = useState([]);
  const [isfilrirano, setIsfiltrirano] = useState([]);

  useEffect(() => {
    getPodaciSRadara()
      .then(podaci => setData(podaci))
      .catch(error => {
        console.error('Error fetching data:', error);
      });
    getPodaciSRadara()
    .then(podaci => setIsfiltrirano(podaci))
    .catch(error => {
      console.error('Error fetching data:', error);
    });
  }, []);

  const getPodaciSRadara = async () => {
    const response = await fetch('http://localhost:8080/getPodaciSRadara', {
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
      [name]: value,
    }));
  };

  const handleFilterSubmit = (e) => {
    e.preventDefault();
    let retVal = [];
    for (let i of data)
    {
      if ((filters.carRegistrationNumber && i.registarskiBrojVozila.includes(filters.carRegistrationNumber)) || (!filters.carRegistrationNumber)) 
      {
        if ((filters.location && i.nazivLokacije.includes(filters.location)) || (!filters.location)) 
      {
        if ((i.vremenskoStanje.toLowerCase().includes(filters.weatherCondition.toLowerCase())) || (filters.weatherCondition==="")) 
        {
          if ((i.tipLokacije.toLowerCase() == filters.locationType.toLowerCase()) || (filters.locationType==="")) 
          {
            if ((!filters.speedLimitFrom) || (filters.speedLimitFrom <= i.ogranicenje)) 
            {
              if ((!filters.speedLimitTo) || (filters.speedLimitTo >= i.ogranicenje)) 
            {
                if ((!filters.detectedSpeedFrom) || (filters.detectedSpeedFrom <= i.zabelezenaBrzina)) 
                {
                  if ((!filters.detectedSpeedTo) || (filters.detectedSpeedTo >= i.zabelezenaBrzina)) 
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
    setIsfiltrirano(retVal);
    
  };



  return (
    <div>
      <AdminNavbar />
      <h1 style={{ marginTop: '30px' }}>Podaci sa radara</h1>
      <form className="mb-3" style={{ width: '66%', margin: '0 auto', marginTop:  '0px'}} onSubmit={handleFilterSubmit}>
        <div className="row">
          <div className="col-md-4">
            <label htmlFor="carRegistrationNumber" className="form-label">Registarski broj vozila:</label>
            <input type="text" id="carRegistrationNumber" className="form-control" name="carRegistrationNumber" value={filters.carRegistrationNumber} onChange={handleFilterChange} />
          </div>
          <div className="col-md-4">
            <label htmlFor="location" className="form-label">Lokacija:</label>
            <input type="text" id="location" className="form-control" name="location" value={filters.location} onChange={handleFilterChange} />
          </div>
          <div className="col-md-2">
            <label htmlFor="weatherCondition" className="form-label">Vremensko stanje:</label>
            <select id="weatherCondition" className="form-control" name="weatherCondition" value={filters.weatherCondition} onChange={handleFilterChange}>
              <option value="">Sve</option>
              <option value="sneg">Sneg</option>
              <option value="kisa">Kisa</option>
              <option value="regularno">Regularno</option>
            </select>
          </div>
          <div className="col-md-2">
            <label htmlFor="locationType" className="form-label">Tip lokacije:</label>
            <select id="locationType" className="form-control" name="locationType" value={filters.locationType} onChange={handleFilterChange}>
              <option value="">Sve</option>
              <option value="naseljeno mesto">Naseljeno mesto</option>
              <option value="nenaseljeno mesto">Nenaseljeno mesto</option>
            </select>
          </div>
        </div>
        <div className="row mt-4">
          <div className="col-md-5">
            <label className="form-label">Ogranicenje:</label>
            <div className="row">
              <div className="col-md-6">
                <label htmlFor="speedLimitFrom" className="form-label">Od:</label>
                <input type="number" id="speedLimitFrom" className="form-control" name="speedLimitFrom" value={filters.speedLimitFrom} onChange={handleFilterChange} />
              </div>
              <div className="col-md-6">
                <label htmlFor="speedLimitTo" className="form-label">Do:</label>
                <input type="number" id="speedLimitTo" className="form-control" name="speedLimitTo" value={filters.speedLimitTo} onChange={handleFilterChange} />
              </div>
            </div>
          </div>
          <div className="col-md-5">
            <label className="form-label">Detektovana brzina:</label>
            <div className="row">
              <div className="col-md-6">
                <label htmlFor="detectedSpeedFrom" className="form-label">Od:</label>
                <input type="number" id="detectedSpeedFrom" className="form-control" name="detectedSpeedFrom" value={filters.detectedSpeedFrom} onChange={handleFilterChange} />
              </div>
              <div className="col-md-6">
                <label htmlFor="detectedSpeedTo" className="form-label">Do:</label>
                <input type="number" id="detectedSpeedTo" className="form-control" name="detectedSpeedTo" value={filters.detectedSpeedTo} onChange={handleFilterChange} />
              </div>
            </div>
          </div>
          <div className="col-md-1 mt-3" style={{position: 'relative', }}>
            <button type="submit" className="btn btn-primary btn-lg" style={{position: 'absolute', top: 0, right: 0,}}>Trazi</button>
          </div>
        </div>
      </form>
      
      <table className="table">
        <thead>
          <tr>
            <th>Registarski broj vozila</th>
            <th>Naziv lokacije</th>
            <th>Vremensko stanje</th>
            <th>Tip lokacije</th>
            <th>Ogranicenje</th>
            <th>Zabelezena brzina</th>
          </tr>
        </thead>
        <tbody>
          {isfilrirano.map((item, index) => (
            <tr key={index}>
              <td>{item.registarskiBrojVozila}</td>
              <td>{item.nazivLokacije}</td>
              <td>{item.vremenskoStanje}</td>
              <td>{item.tipLokacije}</td>
              <td>{item.ogranicenje}</td>
              <td>{item.zabelezenaBrzina}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TrafficDataPage;