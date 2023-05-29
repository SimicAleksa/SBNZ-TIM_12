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
      }
    } else {
      // TODO ovdje uraditi nesto ako nije dobro
      alert('Nepostojeći korisnik');
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

