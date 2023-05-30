import { toast } from "react-toastify";

export const login = async (username, password, navigate) => {
    const response = await fetch('http://localhost:8080/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        email: username,
        sifra: password
      })
    });

    if (response.ok) {
      const korisnik = await response.json();
      if (korisnik.uloga === 'ADMIN') {
        navigate('/register');
      } else if (korisnik.uloga === 'VOZAC') {
        navigate('/vozacevProfil'); 
        localStorage.setItem("email",username);
      }
    } else {
      // TODO ovdje uraditi nesto ako nije dobro
      toast.error("Nevalidni kredencijali");
    }
  }



  export const addDriver = async (driverObject) => {
    const response = await fetch('http://localhost:8080/addDriver', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(driverObject)
    });

    if (response.ok) {
      alert("Uspjesno dodat vozac")
    } else {
      alert('Greska u dodavanju vozaca');
    }
  }


  export const getUserData = async () => {
    const response = await fetch('http://localhost:8080/getUserData', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        email: localStorage.getItem("email"),
        sifra: ""
      })
    });
    if (response.ok) {
      const podaci = await response.json();
      console.log(podaci)
      return podaci;
    } else {
      throw new Error('Error fetching data');
    }
  };

