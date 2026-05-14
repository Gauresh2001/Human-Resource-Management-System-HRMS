# 🚀 Human Resource Management System (HRMS)

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-Framework-brightgreen?style=for-the-badge\&logo=springboot)
![React](https://img.shields.io/badge/React-Frontend-blue?style=for-the-badge\&logo=react)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge\&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Authentication-red?style=for-the-badge\&logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-Educational-lightgrey?style=for-the-badge)

### 💼 Full Stack Human Resource Management System

A modern and secure HRMS application built using Spring Boot and React.js.

</div>

---

# 📖 Overview

The Human Resource Management System (HRMS) is a full-stack web application developed to manage employee records, departments, attendance, authentication, and administrative operations efficiently.

This project is designed using:

* Backend: Java, Spring Boot, Spring Security, Hibernate, JPA
* Frontend: React.js
* Database: MySQL
* Authentication: JWT Token Authentication
* Build Tools: Maven & npm

The system provides separate modules for administrators and employees with secure login and role-based access.

---

# ✨ Features

## 👨‍💼 Admin Module

* Admin Login Authentication
* Dashboard Overview
* Add New Employee
* Update Employee Details
* Delete Employee Records
* Manage Departments
* View All Employees
* Search Employees
* Employee Status Management
* Role-Based Authorization

## 👨‍💻 Employee Module

* Employee Login
* View Personal Profile
* Update Profile
* View Department Details
* Attendance Tracking
* Secure Authentication

---

# 🛠️ Tech Stack

## Backend Technologies

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT Authentication
* Maven
* REST APIs

## Frontend Technologies

* React.js
* React Router DOM
* Axios
* HTML5
* CSS3
* JavaScript

## Database

* MySQL

---

# 📂 Project Structure

```bash
HRMS-Project/
│
├── Backend/
│   ├── src/main/java/com/hrms/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── config/
│   │   ├── security/
│   │   └── exception/
│   │
│   └── src/main/resources/
│       └── application.properties
│
├── Frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   ├── routes/
│   │   └── styles/
│
└── README.md
```

---

# 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE hrms_db;
```

Update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hrms_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

# ⚙️ Backend Setup

## Clone Repository

```bash
git clone https://github.com/Gauresh2001/Human-Resource-Management-System-HRMS.git
```

## Navigate to Backend Folder

```bash
cd Backend
```

## Run Backend Application

```bash
mvn spring-boot:run
```

Backend server will run on:

```bash
http://localhost:8080
```

---

# 🎨 Frontend Setup

## Navigate to Frontend Folder

```bash
cd Frontend
```

## Install Dependencies

```bash
npm install
```

## Start React Application

```bash
npm start
```

Frontend server will run on:

```bash
http://localhost:3000
```

---

# 🔗 API Endpoints

## Authentication APIs

| Method | Endpoint           | Description   |
| ------ | ------------------ | ------------- |
| POST   | /api/auth/login    | User Login    |
| POST   | /api/auth/register | Register User |

## Employee APIs

| Method | Endpoint            | Description        |
| ------ | ------------------- | ------------------ |
| GET    | /api/employees      | Get All Employees  |
| GET    | /api/employees/{id} | Get Employee By ID |
| POST   | /api/employees      | Add Employee       |
| PUT    | /api/employees/{id} | Update Employee    |
| DELETE | /api/employees/{id} | Delete Employee    |

---

# 🔐 Security Features

* JWT Authentication
* Password Encryption
* Role-Based Access Control
* Secure REST APIs
* Protected Routes

---

# 📸 Screenshots

## Login Page

* Secure Login Authentication
* Professional User Interface

## Admin Dashboard

* Employee Management
* Department Overview
* Statistics Dashboard

## Employee Dashboard

* Profile Management
* Attendance Details

---

# 🚀 Future Enhancements

* Payroll Management
* Leave Management System
* Attendance Analytics
* Email Notifications
* Performance Tracking
* File Upload System
* Cloud Deployment

---

# 👨‍💻 Author

## Gauresh Badgujar

* Java Full Stack Developer
* MCA Graduate
* Skilled in Spring Boot & React Development

---

# 🌐 GitHub Repository

urlHuman Resource Management System HRMS Repository[https://github.com/Gauresh2001/Human-Resource-Management-System-HRMS](https://github.com/Gauresh2001/Human-Resource-Management-System-HRMS)

---

# 📜 License

This project is developed for educational and portfolio purposes.

---

# ⭐ Support

If you like this project, give it a star on GitHub and share your feedback.
