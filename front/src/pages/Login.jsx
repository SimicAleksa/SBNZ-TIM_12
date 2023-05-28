import React, {useState} from 'react'
import { ToastContainer, toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import "../css/login.css";


const Login = () => {
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
    // Perform login logic here
    // You can use the email and password values for authentication
    // For simplicity, let's just display the values in the console
    console.log('Email:', email);
    console.log('Password:', password);
    // Reset the form fields
    setEmail('');
    setPassword('');
  };

  
  return (
    <div className="login-page">
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-5">
            <div className="card">
              <div className="card-body">
                <h1 className="card-title text-center">Login</h1>
                <form onSubmit={handleSubmit}>
                  <div className="form-group">
                    <label>Email:</label>
                    <input
                      type="email"
                      className="form-control"
                      value={email}
                      onChange={handleEmailChange}
                      required
                    />
                  </div>
                  <div className="form-group">
                    <label>Password:</label>
                    <input
                      type="password"
                      className="form-control"
                      value={password}
                      onChange={handlePasswordChange}
                      required
                    />
                  </div>
                  <button type="submit" className="btn btn-primary btn-block">Login</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Login;
