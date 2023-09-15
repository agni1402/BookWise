# Bookwise: Library Management REST API
This project implements a RESTful API for library management using Spring Boot and MySQL. The API provides endpoints for common book management operations like adding, updating, deleting, and fetching books.
### Features
- CRUD operations for books
- Search books by title, author, genre, etc.
- User management and auth using Spring Security
- Database schema modeling with JPA
- Exception handling and input validation
### Usage
The API can be consumed by any frontend using the exposed endpoints. Some examples:

- Fetch all books: GET /api/books
- Get a book: GET /api/books/{id}
- Add a new book: POST /api/books
- Update a book: PUT /api/books/{id}
- Delete a book: DELETE /api/books/{id}

#### Installation
The API uses Maven for dependency management. To build and run the app:
- mvn clean install
- mvn spring-boot:run
  
This will start the API on port 8090. The API can then be accessed from http://localhost:8090

#### Database
- The API uses a MySQL database. The schema is automatically created on startup using Hibernate.
- The connection properties are configured in application.properties.

#### Testing
Unit and integration tests are included that verify the API endpoints. Run them using:
- mvn test

## Results with Images
### Add a book(Post)
![Screenshot 2023-09-15 143937](https://github.com/agni1402/BookWise/assets/115021170/c29e220b-0427-49dc-bd5b-f992118ea4db)

### Update a book(Put)
![Screenshot 2023-09-15 144010](https://github.com/agni1402/BookWise/assets/115021170/70f3d4e1-b622-4ab3-912d-531b0fefea47)

### delete a book(Delete)
![Screenshot 2023-09-15 144040](https://github.com/agni1402/BookWise/assets/115021170/92b3787f-4c2a-456c-b9fa-9e3af2fe4697)

### Fetch all Books(Get)
![Screenshot 2023-09-15 143904](https://github.com/agni1402/BookWise/assets/115021170/3482e067-a9e6-4479-ba50-139fc512e2ea)

### instance of the database after operations
![Screenshot 2023-09-15 144326](https://github.com/agni1402/BookWise/assets/115021170/8a55c664-b9a5-438b-86e2-ba047890d4a7)




