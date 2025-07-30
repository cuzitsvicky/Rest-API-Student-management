# 🎓 Student Management REST API

A Spring Boot REST API to manage student records with full CRUD operations, layered architecture, and database integration.



## 🚀 Tech Stack

- Java + Spring Boot  
- Spring Data JPA  
- Maven  
- Postgre SQL 
- Postman  
- Layered Structure: Controller → Service → Repository  



## ✅ Features

- Create, read, update (PUT & PATCH), delete students  
- RESTful design with proper status codes  
- Input validation and exception handling  
- Modular and maintainable code  



## 🔗 API Endpoints

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| GET    | /api/students      | Get all students          |
| GET    | /api/students/{id} | Get student by ID         |
| POST   | /api/students      | Add a new student         |
| PUT    | /api/students/{id} | Full update of student    |
| PATCH  | /api/students/{id} | Partial update of student |
| DELETE | /api/students/{id} | Delete student            |

---

## 📬 Sample Request Bodies

### ➕ POST

{
  "name": "Alice",
  "email": "alice.johnson@example.com",
}


### ✏ PATCH

{
  "email": "alice.updated@example.com"
}





Visit: http://localhost:8080/api/students



## 📁 Project Structure

- controller/ → API layer  
- service/ → Business logic  
- repository/ → Data access  
- model/ → Entity classes
