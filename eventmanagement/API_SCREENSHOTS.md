# API Response Screenshots

This document contains screenshots of the key API endpoints for the Event Management System.

## Required API Screenshots

Please attach screenshots for the following 4 key API endpoints:

### 1. Create User - POST /api/users

**Request:**
```json
{
  "name": "Alice Cooper",
  "email": "alice.cooper@techcorp.com"
}
```
![alt text](image-1.png)


```


### 2. Create Event - POST /api/events

**Request:**
```json
{
  "title": "AI and Machine Learning Conference",
  "description": "Explore the latest trends in artificial intelligence",
  "date": "2024-07-25",
  "location": "Silicon Valley Convention Center"
}
```

![alt text](image-2.png)

---

### 3. Register User to Event - POST /api/registrations

**Request:**
```json
{
  "userId": 1,
  "eventId": 1
}
```

![alt text](image-3.png)

---

### 4. Get All Registrations for Specific Event - GET /api/registrations/event/1

![alt text](image-4.png)

