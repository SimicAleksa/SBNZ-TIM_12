import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import "../css/registracija.css";
import AdminNavbar from '../other/AdminNavbar';


const Registration = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [licenseNumber, setLicenseNumber] = useState('');
    const [registrationNumber, setRegistrationNumber] = useState('');
    const [carModel, setCarModel] = useState('');
    const [carBrand, setCarBrand] = useState('');
    const [carColor, setCarColor] = useState('');
    const [cars, setCars] = useState([]);
  
    const handleFirstNameChange = (e) => {
      setFirstName(e.target.value);
    };
  
    const handleLastNameChange = (e) => {
      setLastName(e.target.value);
    };
  
    const handleLicenseNumberChange = (e) => {
      setLicenseNumber(e.target.value);
    };
  
    const handleRegistrationNumberChange = (e) => {
      setRegistrationNumber(e.target.value);
    };
  
    const handleCarModelChange = (e) => {
      setCarModel(e.target.value);
    };
  
    const handleCarBrandChange = (e) => {
      setCarBrand(e.target.value);
    };
  
    const handleCarColorChange = (e) => {
      setCarColor(e.target.value);
    };
  
    const handleAddCar = (e) => {
      e.preventDefault();
  
      const newCar = {
        registrationNumber,
        carModel,
        carBrand,
        carColor
      };
  
      setCars([...cars, newCar]);
  
      setRegistrationNumber('');
      setCarModel('');
      setCarBrand('');
      setCarColor('');
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
  
      // Handle form submission logic here
  
      setFirstName('');
      setLastName('');
      setLicenseNumber('');
      setCars([]);
    };

    return (
      <div>
        <div style={{position: 'fixed', width: '100%', top: '0px'}}>
        <AdminNavbar/>
        </div>
        <div className="registration-page">
          <div className="card">
            <h1 className="card-title">Dodavanje vozaca</h1>
            <form onSubmit={handleSubmit}>
            <div className='row'>
              <div className="form-group col-md-6">
                <label htmlFor="firstName">Ime</label>
                <input
                  type="text"
                  id="firstName"
                  className="form-control"
                  value={firstName}
                  onChange={handleFirstNameChange}
                  required
                />
              </div>
              <div className="form-group col-md-6">
                <label htmlFor="lastName">Prezime</label>
                <input
                  type="text"
                  id="lastName"
                  className="form-control"
                  value={lastName}
                  onChange={handleLastNameChange}
                  required
                />
              </div>
              </div>
              <div className="form-group">
                <label htmlFor="licenseNumber">Broj vozacke dozvole</label>
                <input
                  type="text"
                  id="licenseNumber"
                  className="form-control"
                  value={licenseNumber}
                  onChange={handleLicenseNumberChange}
                  required
                />
              </div>
              <div className="add-car-container">
                <div className="row">
                  <div className="col-md-6">
                    <label htmlFor="registrationNumber">Registarski broj vozila</label>
                    <input
                      type="text"
                      id="registrationNumber"
                      className="form-control"
                      value={registrationNumber}
                      onChange={handleRegistrationNumberChange}
                    />
                  </div>
                  <div className="col-md-6">
                    <label htmlFor="carModel">Model</label>
                    <input
                      type="text"
                      id="carModel"
                      className="form-control"
                      value={carModel}
                      onChange={handleCarModelChange}
                    />
                  </div>
                </div>
                <div className="row">
                  <div className="col-md-6">
                    <label htmlFor="carBrand">Marka</label>
                    <input
                      type="text"
                      id="carBrand"
                      className="form-control"
                      value={carBrand}
                      onChange={handleCarBrandChange}
                    />
                  </div>
                  <div className="col-md-6">
                    <label htmlFor="carColor">Boja</label>
                    <input
                      type="text"
                      id="carColor"
                      className="form-control"
                      value={carColor}
                      onChange={handleCarColorChange}
                    />
                  </div>
                </div>
                <button className="btn btn-primary" onClick={handleAddCar}>
                  Add Car
                </button>
              </div>
              <div className="added-cars-container">
                {cars.map((car, index) => (
                  <div className="car-info" key={index}>
                    <span className="car-attribute">Registarska oznaka: {car.registrationNumber}</span>
                    <span className="car-attribute">Model: {car.carModel}</span>
                    <span className="car-attribute">Marka: {car.carBrand}</span>
                    <span className="car-attribute">Boja: {car.carColor}</span>
                  </div>
                ))}
              </div>
              <button type="submit" className="btn btn-primary">
                Register
              </button>
            </form>
          </div>
        </div>
      </div>
      );
    };

    export default Registration;