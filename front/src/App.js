import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './pages/Login';
import Registration from './pages/Registration';
import PodaciSaRadara from './pages/PodaciSaRadara';
import KazneAdminPage from './pages/KazneAdmin';
import UserFinesPage from './pages/VozacevProfil';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route index element={<Login />} />
          <Route path='register' element={<Registration/>} />
          <Route path='podaciSaRadara' element={<PodaciSaRadara/>} />
          <Route path='kazneAdmin' element={<KazneAdminPage/>} />
          <Route path='vozacevProfil' element={<UserFinesPage/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
