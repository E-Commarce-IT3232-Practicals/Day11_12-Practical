# 🏛️ Department & Employee Management System – Day 11 & 12

A **Spring Boot REST API** service for managing **departments**, **employees**, and **projects**, designed with a layered architecture, JPQL, and robust error handling.

---

## 📋 Overview

This system models an organization's structure, enabling CRUD and search operations across `Department`, `Employee`, and `Project` entities, with support for analytical queries like employee counts and salary filters.

---

## 🏗 Architecture

Built using a standard layered Spring Boot architecture:

* **Model Layer:** JPA entities with relationships
* **Repository Layer:** JPQL-based Spring Data repositories
* **Service Layer:** Business logic, validations, exception handling
* **Controller Layer:** RESTful APIs
* **Global Exception Handler:** Centralized error responses

---

## ✨ Features

### ✅ Department

* 🔍 Search by department name (partial match)
* 📊 View department details with employee count
* 🔢 Get employee count by department ID
* 📚 List all department names

### ✅ Employee

* 💰 Find employees with salary between a and b

### ✅ Project

* ⚙️ Manage project information (via project assignments)

---

## 🔗 API Endpoints

### 📄 Department APIs

| Endpoint                       | Method | Description                                |
| ------------------------------ | ------ | ------------------------------------------ |
| `/departments/names`           | GET    | Get all department names                   |
| `/departments/search/{name}`   | GET    | Search departments by name (partial)       |
| `/departments/count/{dept_id}` | GET    | Get employee count in a department         |
| `/departments/view/count/{id}` | GET    | Get department details with employee count |

### 👤 Employee APIs

| Endpoint                    | Method | Description                              |
| --------------------------- | ------ | ---------------------------------------- |
| `/employees/salary/{a}/{b}` | GET    | Find employees with salary between a & b |

---

## 📤 Example Output

### 1. 📊 Get Employee Count in Department

**Request:** `GET /departments/count/3`

**Response:**

![1 Get Employee Count in Department](https://github.com/user-attachments/assets/0edc2f31-23ab-4717-810b-b088f83d53f8)

---

### 2. 📚 Get Department Names

**Request:** `GET /departments/names`

**Response:**

![2 Get Department Names](https://github.com/user-attachments/assets/45ad0c59-439f-4108-bf48-9742a7e1ff9e)

---

### 3. 💰 Find Employees Within Salary Range

**Request:** `GET /employees/salary/40000/80000`

**Response:**

![3 Find Employees Within Salary Range](https://github.com/user-attachments/assets/112717c2-ec74-4456-b588-b5318c6ccb9a)

---

### 4. 🔍 Search Departments by Name

**Request:** `GET /departments/search/mark`

**Response:**

![4 Search Departments by Name](https://github.com/user-attachments/assets/ce877512-ae05-4292-8dda-879d91bf5f2d)

---

### 5. 👁️ View Department with Employee Count

**Request:** `GET /departments/view/count/2`

**Response:**

![5 View Department with Employee Count](https://github.com/user-attachments/assets/bd08cf49-003b-42d6-9be9-b12959a80bb2)

---

## ⚠️ Error Response Model

```json
{
  "statusCode": 404,
  "errorMessage": "Department not found"
}
```

| Exception Type            | HTTP Status | Description             |
| ------------------------- | ----------- | ----------------------- |
| `EntityNotFoundException` | 404         | Department not found    |
| `DuplicateKeyException`   | 400         | Duplicate department ID |
| `Exception`               | 500         | Generic server error    |

---

## 🚀 Getting Started

### ✅ Prerequisites

* Java 17+
* MySQL (or H2 for testing)

### ⚙️ Configuration

Update `application.properties`:

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

## 📄 License

This project is part of an academic curriculum and is intended solely for educational purposes.
