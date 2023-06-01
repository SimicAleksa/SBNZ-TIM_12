import React, {useState} from 'react'
import { ToastContainer, toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import "../css/login.css";
import { login } from '../services/UserService';


const Login = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log('Email:', email);
    console.log('Password:', password);
    login(email, password, navigate);
    //setEmail('');
    //setPassword('');
  };

  
  return (
    <div className="login-page">
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-7">
            <div className="card">
              <div className="card-body">
                <h1 className="card-title text-center">Login</h1>
                <form onSubmit={handleSubmit}>

                  <div className="form-group row">
                    <div className='col-md-4'>
                    <label>Email:</label>
                    </div>
                    <div className='col-md-8'>
                    <input
                      type="email"
                      className="form-control"
                      value={email}
                      onChange={handleEmailChange}
                      required
                    />
                    </div>
                  </div>

                  <div className="form-group row">
                  <div className='col-md-4'>
                    <label>Password:</label>
                    </div>
                    <div className='col-md-8'>
                    <input
                      type="password"
                      className="form-control"
                      value={password}
                      onChange={handlePasswordChange}
                      required
                    />
                    </div>
                  </div>
                  <button type="submit" className="btn btn-primary btn-block">Login</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <ToastContainer />
    </div>
  );
};
export default Login;
