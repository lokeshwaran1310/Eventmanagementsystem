# Event Management System

A Spring Boot REST API application for managing events, users, and registrations.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [API Endpoints](#api-endpoints)
- [Setup](#setup)
- [API Screenshots](#api-screenshots)
- [Sample Requests](#sample-requests)
- [Error Handling](#error-handling)
- [Author](#author)
- [License](#license)

## Features

- User management (CRUD operations)
- Event management (CRUD operations)
- Event registration system
- User registration tracking
- Input validation and error handling
- Global exception handling
- Duplicate prevention
- Parameter validation

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **Spring Web**
- **Spring Validation**
- **PostgreSQL**
- **Maven**
- **Jackson (JSON processing)**

## Project Structure

```
eventmanagement/
├── src/main/java/com/example/eventmanagement/
│   ├── controller/          # REST API Controllers
│   │   ├── UserController.java
│   │   ├── EventController.java
│   │   └── RegistrationController.java
│   ├── service/             # Business Logic Layer
│   │   ├── UserService.java
│   │   ├── UserServiceImpl.java
│   │   ├── EventService.java
│   │   ├── EventServiceImpl.java
│   │   ├── RegistrationService.java
│   │   └── RegistrationServiceImpl.java
│   ├── repository/          # Data Access Layer
│   │   ├── UserRepository.java
│   │   ├── EventRepository.java
│   │   └── RegistrationRepository.java
│   ├── domain/              # JPA Entity Classes
│   │   ├── User.java
│   │   ├── Event.java
│   │   └── Registrations.java
│   ├── dto/                 # Data Transfer Objects
│   │   ├── UserRequestDto.java
│   │   ├── UserResponseDto.java
│   │   ├── EventRequestDto.java
│   │   ├── EventResponseDto.java
│   │   ├── RegistrationRequestDto.java
│   │   └── RegistrationResponseDto.java
│   ├── mapper/              # Entity-DTO Mappers
│   │   ├── UserMapper.java
│   │   ├── EventMapper.java
│   │   └── RegistrationsMapper.java
│   ├── exceptions/          # Custom Exception Classes
│   │   ├── GlobalExceptions.java
│   │   ├── ResourceNotFoundException.java
│   │   ├── DuplicateResourceException.java
│   │   ├── InvalidRequestException.java
│   │   └── RegistrationLimitExceededException.java
│   └── EventmanagementApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

## Database Schema

### Tables
- `event_users` - User information
- `events` - Event details
- `registrations` - User-Event registrations

## API Endpoints

### Users
- `POST /api/users` - Create user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Events
- `POST /api/events` - Create event
- `GET /api/events` - Get all events
- `GET /api/events/{id}` - Get event by ID
- `PUT /api/events/{id}` - Update event
- `DELETE /api/events/{id}` - Delete event

### Registrations
- `POST /api/registrations` - Register user to event
- `GET /api/registrations` - Get all registrations
- `GET /api/registrations/{id}` - Get registration by ID
- `GET /api/registrations/user/{userId}` - Get registrations by user
- `GET /api/registrations/event/{eventId}` - Get registrations by event
- `DELETE /api/registrations/{id}` - Delete registration

## Setup

1. **Database Setup**
   ```sql
   CREATE DATABASE postgres;
   ```

2. **Configuration**
   Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   server.port=8094
   ```

3. **Run Application**
   ```bash
   mvn spring-boot:run
   ```

## API Screenshots

📸 **[View API Response Screenshots](API_SCREENSHOTS.md)**

For visual documentation of API responses, please refer to the dedicated screenshots document which includes:
- Create User Response
- Create Event Response  
- Register User to Event Response
- Get Registrations by Event Response

## Sample Requests

### Create User
```json
POST /api/users
{
  "name": "Alice Cooper",
  "email": "alice.cooper@techcorp.com"
}
```

### Create Event
```json
POST /api/events
{
  "title": "AI Conference",
  "description": "Latest trends in AI technology",
  "date": "2024-07-25",
  "location": "Tech Center"
}
```

### Register User to Event
```json
POST /api/registrations
{
  "userId": 1,
  "eventId": 1
}
```

## Error Handling

The application includes comprehensive error handling with custom exceptions:

- `400 Bad Request` - Invalid input data or parameters
- `404 Not Found` - Resource not found
- `409 Conflict` - Duplicate resource (email, registration)
- `500 Internal Server Error` - Server error

### Custom Exceptions
- **ResourceNotFoundException** - When requested entity doesn't exist
- **DuplicateResourceException** - When trying to create duplicate resources
- **InvalidRequestException** - When request parameters are invalid
- **RegistrationLimitExceededException** - For future registration limits

## Author

**Lokeshwaran M**  
Software Developer  
Email: lokeshwaran.m@epssw.com  


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 Lokesh M

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```