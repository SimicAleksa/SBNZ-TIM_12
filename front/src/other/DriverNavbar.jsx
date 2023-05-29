import React from 'react';
import { Link } from 'react-router-dom';
import '../css/AdminNavbar.css';


const DriverNavbar = () => {
    return (
        <nav className="navbar navbar-dark bg-dark navbar-fixed-top">
          <div className="container">
            <Link className="navbar-brand" to="/">My App</Link>
            <ul className="navbar-nav d-flex flex-row">
              <li className="nav-item">
                <Link className="nav-link" to="/register">Moje kazne</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/">Odjavi se</Link>
              </li>
            </ul>
          </div>
        </nav>
      );
    };
  
  export default DriverNavbar;