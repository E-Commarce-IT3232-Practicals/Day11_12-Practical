# 🏛️ Department & Employee Management System - Day 11 & 12

A Spring Boot REST API service for managing departments, employees, and projects, using a layered architecture with JPA, JPQL, and proper error handling.

---

## 📋 Overview

This system models a company's organizational structure with entities such as `Department`, `Employee`, `Project`, and `ProjectAssignment`. It supports operations like department CRUD, employee search by salary range, department views with employee counts, and more.

---

## 🏗 Architecture

Follows the standard layered Spring Boot architecture:

- **Model Layer:** JPA entities with relationships
- **Repository Layer:** JPQL-based Spring Data repositories
- **Service Layer:** Business logic and exception handling
- **Controller Layer:** RESTful APIs
- **Global Exception Handler:** Centralized error responses

---

## ✨ Features

### ✅ Department
- Get all departments
- Get department by ID
- Add a new department with unique ID check
- Update an existing department
- Delete department
- Search department by name (partial match)
- View department with employee count
- Get employee count in a department
- Get all department names

### ✅ Employee
- Find employees with salary between a and b
- Future support for project assignment querying

### ✅ Project
- Manage project data (internal support through project assignments)

---

## 🔗 API Endpoints

### 📄 Department APIs

| Endpoint                               | Method | Description                              |
|----------------------------------------|--------|------------------------------------------|
| `/departments`                         | GET    | Get all departments                      |
| `/departments/{id}`                    | GET    | Get department by ID                     |
| `/departments`                         | POST   | Add new department                       |
| `/departments/{id}`                    | PUT    | Update department                        |
| `/departments/{id}`                    | DELETE | Delete department                        |
| `/departments/names`                   | GET    | Get all department names                 |
| `/departments/search/{name}`          | GET    | Search departments by name (partial)     |
| `/departments/count/{dept_id}`         | GET    | Get employee count in department         |
| `/departments/view/count/{id}`         | GET    | Get department details with employee count |

### 👤 Employee APIs

| Endpoint                                  | Method | Description                              |
|-------------------------------------------|--------|------------------------------------------|
| `/employees/salary/{a}/{b}`               | GET    | Find employees with salary between a & b |

---

## ⚠️ Error Response Model

```json
{
  "statusCode": 404,
  "errorMessage": "Department not found"
}
```

| Exception Type          | HTTP Status | Description             |
| ----------------------- | ----------- | ----------------------- |
| EntityNotFoundException | 404         | Department not found    |
| DuplicateKeyException   | 400         | Duplicate department ID |
| Exception               | 500         | Generic server error    |

---

## 🛠 Technology Stack

* Java 17+
* Spring Boot 3.x
* Spring Data JPA (Hibernate)
* JPQL & Custom Queries
* MySQL / H2 (company DB)
* Maven
* Jackson (JSON handling)
* Lombok (optional)
* Spring REST ControllerAdvice

---

## 🚀 Getting Started

### ✅ Prerequisites

* Java 17+
* MySQL (or H2 for testing)

### ⚙️ Configuration

Update your `application.properties`:

```properties
spring.application.name=employeeapp
spring.datasource.url=jdbc:mysql://localhost:3306/company
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧠 Business Logic Summary

### ➕ Add Department

* Validates ID uniqueness
* Saves department
* Throws `DuplicateKeyException` if ID exists

### 🔍 Get Department by ID

* Returns department if found
* Throws `EntityNotFoundException` otherwise

### ✏️ Update Department

* Checks existence
* Updates department or throws error

### 🗑️ Delete Department

* Checks existence
* Deletes or throws not found exception

---

## 📤 Example Output

### ➕ Add Success

```json
{
  "statusCode": 201,
  "message": "Department created successfully"
}
```

### ❌ Duplicate ID Error

```json
{
  "statusCode": 400,
  "errorMessage": "Department with ID already exists"
}
```

---

## 📄 License

This project is a part of an academic curriculum and is intended for learning purposes.
