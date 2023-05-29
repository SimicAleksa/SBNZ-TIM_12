import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import { BsCheckCircle, BsXCircle } from 'react-icons/bs';
import "../css/vozaceveKazne.css";
import DriverNavbar from '../other/DriverNavbar';



const UserFinesPage = () => {
    const user = {
      name: 'John Doe',
      accountBalance: 500,
      fines: [
        {
          id: 1,
          date: '2023-05-15',
          fine: 100,
          penaltyPoints: 3,
          prisonSentence: 10,
          isPaid: false,
          isActive: true
        },
        {
            id: 1,
            date: '2023-05-15',
            fine: 100,
            penaltyPoints: 3,
            prisonSentence: 15,
            isPaid: false,
            isActive: true
          },
          {
            id: 1,
            date: '2023-05-15',
            fine: 100,
            penaltyPoints: 3,
            prisonSentence: 0,
            isPaid: false,
            isActive: true
          },
          {
            id: 1,
            date: '2023-05-15',
            fine: 100,
            penaltyPoints: 3,
            prisonSentence: 0,
            isPaid: false,
            isActive: true
          }
        // Add more fine objects as needed
      ]
    };
  
    return (
      <div>
        <div style={{position: 'fixed', width: '100%', top: '0px'}}>
      <DriverNavbar/>
      </div>
      <div id="backgroundDiv-vozac">
        <div style={{ width: '65%', margin: '0 auto', marginTop: '60px'}} id='outerDiv' class='shadow'>
        <h1>{user.name}</h1>
        <div className="account-info">My account: {user.accountBalance}$</div>
  
        <div className="fine-list">
          {user.fines.map((fine) => (
            <div className="fine-item-vozac" key={fine.id}>
              <div className="row">
                <div className="col-md-4">
                <label>Datum: <b>{fine.date}</b></label>
                </div>
              </div>
              <div className="row">
                <div className="col-md-4">Novcani iznos: <b>{fine.fine} </b>RSD</div>
                <div className="col-md-3">Kazneni poeni: <b>{fine.penaltyPoints}</b></div>
                <div className="col-md-5">Duzina zatvorske kazne: <b>{fine.prisonSentence}</b></div>
              </div>
              <div className="row">
                <div className="col-md-4">
                <label> Kazna je placena: </label>
                    {fine.isPaid ? <BsCheckCircle className="icon-positive" /> : <BsXCircle className="icon-negative" />}
                </div>
                <div className="col-md-4">
                <label>Kazna je aktivna: </label>
                    {fine.isActive ? <BsCheckCircle className="icon-positive"/> : 
                    <BsXCircle className="icon-negative" />}
                </div>
              </div>
              <div className="row">
                <div className="col-md-12 text-right">
                  <button className="btn btn-primary">Pay</button>
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