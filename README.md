# 📚 Student Management System

A RESTful Student Management System built using **Java, Spring Boot, Spring Data JPA, PostgreSQL, and Swagger**. The application provides APIs for managing student records with support for CRUD operations, search functionality, and Excel export.

---

## 🚀 Features

- ✅ Create Student
- ✅ Update Student
- ✅ Get All Students
- ✅ Get Student by ID
- ✅ Delete Student
- ✅ Search Student by Name
- ✅ Export Students to Excel (.xlsx)
- ✅ API Documentation with Swagger UI

---

## 🛠 Tech Stack

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL
- Apache POI
- Lombok
- Maven
- Swagger / OpenAPI

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.studentmanagementsystem.StudentManagementSystem
│   │       ├── config
│   │       ├── controller
│   │       ├── converter
│   │       ├── entity
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       │   └── impl
│   │       └── StudentManagementSystemApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── test
```

---

## ⚙️ Setup Instructions

### Clone the Repository

```bash
git clone https://github.com/Kartik-exe/Student-Management-System.git
```

Navigate to the project:

```bash
cd Student-Management-System
```

---

## Configure PostgreSQL

Create a database:

```sql
CREATE DATABASE student_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Run the Application

Using Maven:

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

## 📖 Swagger Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Docs:

```text
http://localhost:8080/v3/api-docs
```

---

# 📌 API Endpoints

## Create Student

```http
POST /student/create
```

### Request Body

```json
{
  "name": "Kartik Nigam",
  "email": "kartik@example.com"
}
```

---

## Get All Students

```http
GET /student
```

---

## Get Student By ID

```http
GET /student/{id}
```

Example:

```http
GET /student/1
```

---

## Update Student

```http
PUT /student/update/{id}
```

Request Body:

```json
{
  "name": "Updated Name",
  "email": "updated@example.com"
}
```

---

## Delete Student

```http
DELETE /student/{id}
```

---

## Search Student

```http
GET /student/search?name=kartik
```

---

## Export Students to Excel

```http
GET /student/export/excel
```

Downloads:

```text
students.xlsx
```

---

## Sample Response

```json
{
  "id": 1,
  "name": "Kartik Nigam",
  "email": "kartik@example.com"
}
```

---

## Future Enhancements

- Pagination and Sorting
- CSV Export
- Global Exception Handling
- Validation using `@Valid`
- Unit Testing with JUnit and Mockito
- Spring Security with JWT Authentication
- Docker Support
- CI/CD Pipeline with GitHub Actions

---

## 👨‍💻 Author

**Kartik Nigam**

- GitHub: https://github.com/Kartik-exe
- LinkedIn: www.linkedin.com/in/kartiknigam24

---

## ⭐ If you found this project useful, consider giving it a star!