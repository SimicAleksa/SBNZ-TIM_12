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
        navigate('/vozacevProfil'); // Replace '/driver' with the actual driver page URL
      }
    } else {
      // Request failed
      // Handle the login failure
      alert('Nepostojeći korisnik');
    }
  }
