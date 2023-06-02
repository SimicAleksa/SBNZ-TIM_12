import json
import requests
import time

url_za_inicijalizaciju = 'http://localhost:8080/init'
url_za_ubrzavanjeVremena = 'http://localhost:8080/advanceTime'
url = 'http://localhost:8080/radar'


prviPodatak = {
    'id': "10",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Veternik',
    'zabelezenaBrzina': 62.35,
    'vremenskoStanje': 'kisa',
    'tipLokacije': 'naseljeno mesto',
}

drugiPodatak = {
    'id': "11",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Liman',
    'zabelezenaBrzina': 47.00,
    'vremenskoStanje': 'kisa',
    'tipLokacije': 'naseljeno mesto',
}

treciPodatak = {
    'id': "12",
    'registarskiBrojVozila': '065-AV-243',
    'nazivLokacije': 'Detelinara',
    'zabelezenaBrzina': 110.00,
    'vremenskoStanje': 'sneg',
    'tipLokacije': 'naseljeno mesto',
}

############################### drugi vozac

cetvrtiPodatak = {
    'id': "20",
    'registarskiBrojVozila': '123-NS-456',
    'nazivLokacije': 'Liman',
    'zabelezenaBrzina': 80.00,
    'vremenskoStanje': 'regularno',
    'tipLokacije': 'naseljeno mesto',
}
# 6 kaznenih


petiPodatak = {
    'id': "21",
    'registarskiBrojVozila': '123-NS-456',
    'nazivLokacije': 'Detelinara',
    'zabelezenaBrzina': 36.00,
    'vremenskoStanje': 'sneg',
    'tipLokacije': 'naseljeno mesto',
}

sestiPodatak = {
    'id': "22",
    'registarskiBrojVozila': '123-NS-456',
    'nazivLokacije': 'Liman',
    'zabelezenaBrzina': 95.00,
    'vremenskoStanje': 'sneg',
    'tipLokacije': 'naseljeno mesto',
}
# 7 kaznenih

sedmiPodatak = {
    'id': "23",
    'registarskiBrojVozila': '123-NS-456',
    'nazivLokacije': 'Detelinara',
    'zabelezenaBrzina': 120.00,
    'vremenskoStanje': 'regularno',
    'tipLokacije': 'nenaseljeno mesto',
}
# 3 kaznena

osmiPodatak = {
    'id': "24",
    'registarskiBrojVozila': '123-NS-456',
    'nazivLokacije': 'Detelinara',
    'zabelezenaBrzina': 30.00,
    'vremenskoStanje': 'regularno',
    'tipLokacije': 'nenaseljeno mesto',
}
# nije prekrsio pravila, ali je vozio bez dozvole



headers = {'Content-Type': 'application/json'}
response = requests.post(url_za_inicijalizaciju, headers=headers)
time.sleep(2)
response = requests.post(url, json=prviPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=drugiPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=treciPodatak, headers=headers)
time.sleep(2)

# ubrzavanje vremena
response = requests.post(url_za_ubrzavanjeVremena, headers=headers)
time.sleep(2)
response = requests.post(url_za_ubrzavanjeVremena, headers=headers)

time.sleep(2)
response = requests.post(url, json=cetvrtiPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=petiPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=sestiPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=sedmiPodatak, headers=headers)
time.sleep(2) 
response = requests.post(url, json=osmiPodatak, headers=headers)