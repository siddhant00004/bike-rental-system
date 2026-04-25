# Bike Rental System

##  Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Hibernate (JPA)

##  Features
- Add and view bikes
- Rent bike
- Return bike with cost calculation
- User management

##  APIs
- POST /bikes
- GET /bikes
- POST /rent
- POST /return

##  Concepts Used
- REST APIs
- @ManyToOne Mapping
- LocalDateTime for duration calculation

##  How to Run
1. Clone repo
2. Configure DB in application.properties
3. Run Spring Boot app

##  Sample Requests

### Rent Bike
POST /rent?userId=1&bikeId=3

### Return Bike
POST /return?rentalId=1
