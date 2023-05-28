import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import "../css/kazne.css";
import { BsCheckCircle, BsXCircle } from 'react-icons/bs';



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
  
    const [fines, setFines] = useState([
      // Your initial fines data goes here
      // Replace this with your actual data or fetch it from an API
      {
        carRegistrationNumber: 'ABC123',
        driverLicenseNumber: '123456',
        fine: 100,
        penaltyPoints: 3,
        prisonSentence: 15,
        date: '2022-01-01',
        isPaid: true,
        isActive: true
      },
      {
        carRegistrationNumber: 'DEF456',
        driverLicenseNumber: '789012',
        fine: 200,
        penaltyPoints: 5,
        prisonSentence: 0,
        date: '2022-02-15',
        isPaid: false,
        isActive: true
      },
      {
        carRegistrationNumber: 'ABC123',
        driverLicenseNumber: '123456',
        fine: 100,
        penaltyPoints: 3,
        prisonSentence: 15,
        date: '2022-01-01',
        isPaid: true,
        isActive: true
      },
      {
        carRegistrationNumber: 'DEF456',
        driverLicenseNumber: '789012',
        fine: 200,
        penaltyPoints: 5,
        prisonSentence: 0,
        date: '2022-02-15',
        isPaid: false,
        isActive: true
      },
      // Add more fines as needed
    ]);
  
    const handleFilterChange = (e) => {
      const { name, value } = e.target;
      setFilters((prevFilters) => ({
        ...prevFilters,
        [name]: value
      }));
    };
  
    const handleFilterSubmit = (e) => {
      e.preventDefault();
      // Apply the filters to the fines data
      const filteredFines = fines.filter((fine) => {
        // Check if each field matches the corresponding filter value
        return (
          fine.carRegistrationNumber.toLowerCase().includes(filters.carRegistrationNumber.toLowerCase()) &&
          fine.driverLicenseNumber.toLowerCase().includes(filters.driverLicenseNumber.toLowerCase()) &&
          fine.fine.toString().includes(filters.fine) &&
          fine.penaltyPoints.toString().includes(filters.penaltyPoints) &&
          fine.prisonSentence.toLowerCase().includes(filters.prisonSentence.toLowerCase()) &&
          (fine.date >= filters.startDate || !filters.startDate) &&
          (fine.date <= filters.endDate || !filters.endDate) &&
          (fine.isPaid === (filters.isPaid === 'true' || filters.isPaid === '')) &&
          (fine.isActive === (filters.isActive === 'true' || filters.isActive === ''))
        );
      });
  
      // Update the fines with the filtered results
      setFines(filteredFines);
    };


    return (
      <div id="backgroundDiv">
      <div style={{ width: '50%', margin: '0 auto'}} id='outerDiv' class='shadow'>
      <form class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label>Registracioni broj vozila:</label>
            <input class="form-control" type="text" name="carRegistrationNumber" />
          </div>
          <div class="col-md-6">
            <label>Broj vozacke dozvole:</label>
            <input class="form-control" type="text" name="driverLicenseNumber" />
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label>Visina novcane kazne:</label>
            <input class="form-control" type="number" name="fine" />
          </div>
          <div class="col-md-4">
            <label>Kazneni poeni:</label>
            <input class="form-control" type="number" name="penaltyPoints" />
          </div>
          <div class="col-md-4">
            <label>Duzina zatvorske kazne:</label>
            <input class="form-control" type="number" name="prisonSentence" />
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <label>Datum - od:</label>
            <input class="form-control" type="date" name="startDate" />
          </div>
          <div class="col-md-6">
            <label>Datum - do:</label>
            <input class="form-control" type="date" name="endDate" />
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label>Kazna je placena:</label>
            <select class="form-control" name="isPaid">
              <option value="">All</option>
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
          </div>
          <div class="col-md-4">
            <label>Kazna je aktivna:</label>
            <select class="form-control" name="isActive">
              <option value="">All</option>
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
          </div>
          <div class="col-md-4 mt-4 mr-0">
            <button type="submit" class="btn btn-primary">Filter</button>
          </div>
        </div>
      </form>
      <hr></hr>


      <div className="fines-list">
  {fines.map((fine, index) => (
    <div className="fine-item rounded" key={index} class="shadow mb-3 mt-2 bg-light">
      <div className="fine-row" class='row'>
        <div className="attribute" class="col-md-6">
          <label>Registracioni broj vozila: <b> {fine.carRegistrationNumber}</b></label>
        </div>
        <div className="attribute" class="col-md-6">
          <label>Broj vozacke dozvole:<b> {fine.driverLicenseNumber}</b></label>   
        </div>
      </div>
      <div className="fine-row">
        <div className="attribute" class="col-md-4">
          <label>Visina novcane kazne:<b>{fine.fine}</b></label>
        </div>
        <div className="attribute" class="col-md-4">
          <label>Kazneni poeni:<b>{fine.penaltyPoints}</b></label>
          
        </div>
        <div className="attribute" class="col-md-4">
          <label>Duzina zatvorske kazne:<b>{fine.prisonSentence}</b></label>
        </div>
      </div>
      <div className="fine-row">
        <div className="attribute" class="col-md-4">
          <label>Datum: <b>{fine.date}</b></label>
        </div>
        <div className="attribute" class="col-md-4">
        <label>Kazna je placena: </label>
        {fine.isPaid ? <BsCheckCircle className="icon-positive" /> : <BsXCircle className="icon-negative" />}
      </div>
      <div className="attribute" class="col-md-4">
        <label>Kazna je aktivna: </label>
        {fine.isActive ? <BsCheckCircle className="icon-positive"/> : 
        <BsXCircle className="icon-negative" />}
      </div>
      </div>
      <hr></hr>
    </div>
    
  ))}

</div>
 
    </div>

    </div>
    );
  };

export default KazneAdminPage;