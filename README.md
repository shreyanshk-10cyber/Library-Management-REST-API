# Library Management REST API

## Project Overview
A RESTful API developed using Spring Boot to manage college library book records.

## Technologies Used
- Java
- Spring Boot
- Spring Web MVC
- Maven
- IntelliJ IDEA

## Book Attributes
- id
- title
- author
- category
- availableCopies

## Features
1. Add a new book using POST.
2. Retrieve all books using GET.
3. Retrieve a specific book by ID.
4. Update book details using PUT.
5. Delete a book using DELETE.
6. Return appropriate HTTP responses for successful operations and when a book is not found.

## API Endpoints

| Method | Endpoint | Operation |
|---|---|---|
| POST | /books | Add book |
| GET | /books | Get all books |
| GET | /books/{id} | Get book by ID |
| PUT | /books/{id} | Update book |
| DELETE | /books/{id} | Delete book |

## How to Run
1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Load Maven dependencies.
4. Run `Mse2Application.java`.
5. Test the API using Postman.

## Author
Shreyansh
