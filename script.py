import json
import requests
import time

url_za_brisanje = 'http://localhost:8080/delete'
url_za_inicijalizaciju = 'http://localhost:8080/init'
url = 'http://localhost:8080/radar'

prviPodatak = {
    'id': "10",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Veternik',
    'zabelezenaBrzina': 58.35,
    'vremenskoStanje': 'kisa',
    'tipLokacije': 'naseljeno mesto',
}

drugiPodatak = {
    'id': "11",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Detelinara',
    'zabelezenaBrzina': 68.35,
    'vremenskoStanje': 'kisa',
    'tipLokacije': 'naseljeno mesto',
}

treciPodatak = {
    'id': "12",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Liman',
    'zabelezenaBrzina': 47.00,
    'vremenskoStanje': 'kisa',
    'tipLokacije': 'naseljeno mesto',
}

headers = {'Content-Type': 'application/json'}
response = requests.post(url_za_brisanje, headers=headers)
time.sleep(1)
response = requests.post(url_za_brisanje, headers=headers)
time.sleep(2)
response = requests.post(url, json=prviPodatak, headers=headers)
time.sleep(3) 
response = requests.post(url, json=drugiPodatak, headers=headers)
time.sleep(3) 
response = requests.post(url, json=treciPodatak, headers=headers)
