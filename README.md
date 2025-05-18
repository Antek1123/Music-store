# Projekt music-store

Projekt został wykonany na potrzebę przedmiotu "Modelowanie i Analiza Systemów informacyjnych" na uczelni Polsko Japońska Akademia Technik Komputerowych. Celem projektu było wykonanie wykonanie oraz część implementacji prostego systemu informatycznego dla poszczególnej dziedziny problemowej. 

Postanowiłem wykonać i opisać potencjalny system dla sieci sklepów muzycznych. Celem utworzenia systemu jest ułatwienie zarządzania internetowym sklepem, poprawienie dostępu do danych a także usprawnienie zarządzania zespołem, dzięki czemu poprawi się działanie sklepu, co przełoży się pozytywnie na liczbę zadowolonych klientów oraz obrót sprzedażowy.

Prototyp napisany przeze mnie skupia się na fragmencie aplikacji serwera (komunikującej się z bazą danych) oraz fragmentu systemu CMS (aplikacja webowa). 
Aplikacja frontendowa została napisana w języku Javascript z wykorzystaniem framework'a React, natomiast aplikacja backendowa została napisana w Javie z wykorzystaniem Spring boot'a. Jako baza danych został wygrany PostgreSQL. 

W celu uruchomienia aplikacji należy:
1. sklonować repozytorium
2. uruchomić bazę danych oraz skonfigurować połączenie w pliku `application.properties`
3. wybudować aplikację backendową w katalogu cms-backend za pomocą komendy `./gradlew clean build`
4. uruchomić aplikację `./gradlew bootRun`
5. wybudować aplikację frontendowąw katalogu cms-gui `npm install`
6. uruchomić aplikację `npm run`

Dokumentacja w języku polskim dostępna jest w katalogu projektu - `dokumentacja_sklep_muzyczny.pdf`.

---

# Music-Store Project

This project was created for the subject "Modeling and Analysis of Information Systems" at the Polish-Japanese Academy of Information Technology. The goal of the project was to design and partially implement a simple information system for a specific problem domain.

I decided to design and describe a potential system for a chain of music stores. The purpose of this system is to facilitate the management of the online store, improve data accessibility, and streamline team management. As a result, the store’s operations will improve, leading to increased customer satisfaction and higher sales turnover.

The prototype I developed focuses on part of the server application (which communicates with the database) and a part of the CMS system (a web application).
The frontend application was written in JavaScript using the React framework, while the backend application was developed in Java using Spring Boot. PostgreSQL was used as the database.

To run the application, follow these steps:
1. Clone the repository
2. Start the database and configure the connection in the application.properties file
3. Build the backend application in the cms-backend directory using the command ./gradlew clean build
4. Run the backend application with ./gradlew bootRun
5. Build the frontend application in the cms-gui directory using npm install
6. Run the frontend application using npm run.

Documentation is available in polish language in the project main directory - `dokumentacja_sklep_muzyczny.pdf`
