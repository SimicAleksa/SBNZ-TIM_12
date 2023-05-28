import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';


//export default function PodaciSaRadara() {
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
    
    const [data, setData] = useState([
        
        {
        carRegistrationNumber: 'AV 065',
        location: 'Veternik',
        locationType: 'naseljeno mesto',
        detectedSpeed: 48,
        weatherCondition: 'Regular',
        speedLimit: 50
        },
    ]);
    
    const handleFilterChange = (e) => {
        const { name, value } = e.target;
        setFilters((prevFilters) => ({
        ...prevFilters,
        [name]: value,
        }));
    };
    
    const handleFilterSubmit = (e) => {
        e.preventDefault();

        const filteredData = data.filter((item) => {
        return (
            item.location.toLowerCase().includes(filters.location.toLowerCase()) &&
            item.weatherCondition.toLowerCase().includes(filters.weatherCondition.toLowerCase()) &&
            item.carRegistrationNumber.toLowerCase().includes(filters.carRegistrationNumber.toLowerCase()) &&
            item.locationType.toLowerCase().includes(filters.locationType.toLowerCase()) &&
            (item.speedLimit >= Number(filters.speedLimitFrom) || !filters.speedLimitFrom) &&
            (item.speedLimit <= Number(filters.speedLimitTo) || !filters.speedLimitTo) &&
            (item.detectedSpeed >= Number(filters.detectedSpeedFrom) || !filters.detectedSpeedFrom) &&
            (item.detectedSpeed <= Number(filters.detectedSpeedTo) || !filters.detectedSpeedTo)
        );
        });
    
        setData(filteredData);
        console.log(filteredData + " su filtrirani podaci");
    };



   return (
    <div>
  <h1>Traffic Data</h1>
  <form className="mb-3" style={{ width: '66%', margin: '0 auto' }} onSubmit={handleFilterSubmit}>
    <div className="row">
      <div className="col-md-4">
        <label htmlFor="carRegistrationNumber" className="form-label">Car Registration Number:</label>
        <input type="text" id="carRegistrationNumber" className="form-control" name="carRegistrationNumber" value={filters.carRegistrationNumber} onChange={handleFilterChange} />
      </div>
      <div className="col-md-4">
        <label htmlFor="location" className="form-label">Location:</label>
        <input type="text" id="location" className="form-control" name="location" value={filters.location} onChange={handleFilterChange} />
      </div>
      <div className="col-md-2">
        <label htmlFor="weatherCondition" className="form-label">Weather Condition:</label>
        <select id="weatherCondition" className="form-control" name="weatherCondition" value={filters.weatherCondition} onChange={handleFilterChange}>
          <option value="">All</option>
          <option value="snow">Snow</option>
          <option value="rain">Rain</option>
          <option value="regular">Regular</option>
        </select>
      </div>
      <div className="col-md-2">
        <label htmlFor="locationType" className="form-label">Location Type:</label>
        <select id="locationType" className="form-control" name="locationType" value={filters.locationType} onChange={handleFilterChange}>
          <option value="">All</option>
          <option value="Inhabited">Inhabited</option>
          <option value="Uninhabited">Uninhabited</option>
        </select>
      </div>
    </div>
    <div className="row mt-4">
      <div className="col-md-5">
        <label className="form-label">Speed Limit:</label>
        <div className="row">
          <div className="col-md-6">
            <label htmlFor="speedLimitFrom" className="form-label">From:</label>
            <input type="number" id="speedLimitFrom" className="form-control" name="speedLimitFrom" value={filters.speedLimitFrom} onChange={handleFilterChange} />
          </div>
          <div className="col-md-6">
            <label htmlFor="speedLimitTo" className="form-label">To:</label>
            <input type="number" id="speedLimitTo" className="form-control" name="speedLimitTo" value={filters.speedLimitTo} onChange={handleFilterChange} />
          </div>
        </div>
      </div>
      <div className="col-md-5">
        <label className="form-label">Detected Speed:</label>
        <div className="row">
          <div className="col-md-6">
            <label htmlFor="detectedSpeedFrom" className="form-label">From:</label>
            <input type="number" id="detectedSpeedFrom" className="form-control" name="detectedSpeedFrom" value={filters.detectedSpeedFrom} onChange={handleFilterChange} />
          </div>
          <div className="col-md-6">
            <label htmlFor="detectedSpeedTo" className="form-label">To:</label>
            <input type="number" id="detectedSpeedTo" className="form-control" name="detectedSpeedTo" value={filters.detectedSpeedTo} onChange={handleFilterChange} />
          </div>
        </div>
      </div>
      <div className="col-md-1 mt-3" style={{position: 'relative', }}>
  <button type="submit" className="btn btn-primary btn-lg" style={{position: 'absolute', bottom: 0, right: 0,}}>Filter</button>
</div>
    </div>
  </form>
  <table className="table">
    <thead>
      <tr>
        <th>Car Registration Number</th>
        <th>Location</th>
        <th>Weather Condition</th>
        <th>Location Type</th>
        <th>Speed Limit</th>
        <th>Detected Speed</th>
      </tr>
    </thead>
    <tbody>
      
    </tbody>
  </table>
</div>
);
}

export default TrafficDataPage;