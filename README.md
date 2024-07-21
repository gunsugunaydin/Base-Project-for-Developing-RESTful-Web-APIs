# Base Project for Developing RESTful Web APIs
RestBaseProject is a backend Spring Boot web application designed to provide a secure and clean foundation for developing RESTful web APIs. This project includes essential components such as security features, account management, and token generation.

## Features
- **Authentication and Authorization**: Secure the application with JWT tokens.
- **Account Management**: CRUD operations for user accounts.
- **Token Generation**: Generate JWT tokens for authenticated users.
- **Profile Management**: View, update, and delete user profiles.
- **Swagger Integration**: API documentation with Swagger.

## Technologies Used
- **Spring Boot**: Framework for building the application.
- **Spring Security**: For authentication and authorization.
- **JWT**: JSON Web Token for securing endpoints.
- **Swagger**: API documentation tool.
- **Lombok**: For reducing boilerplate code.

## Endpoints
### Authentication
- **POST /api/v1/auth/token** : Generate a new token for a user.

### Account Management
- **POST /api/v1/auth/users/add** : Add a new user.
- **GET /api/v1/auth/users/list** : List all users.
- **PUT /api/v1/auth/users/{user_id}/update-authorities** : Update user authorities.

### Profile Management
- **GET /api/v1/auth/profile** : View the authenticated user's profile.
- **PUT /api/v1/auth/profile/update-password** : Update the authenticated user's password.
- **DELETE /api/v1/auth/profile/delete** : Delete the authenticated user's profile.

## Setup and Installation
### Clone the Repository
```sh
git clone https://github.com/gunsugunaydin/Base-Project-for-Developing-RESTful-Web-APIs.git

### Build the Project
```sh
mvn clean install
### Run the Application
mvn spring-boot:run

## Swagger UI

![Ekran görüntüsü 2024-07-21 225029](https://github.com/user-attachments/assets/6c41088a-8b28-438f-9955-ed2023039ed7)

The above screenshot shows the Swagger user interface. You can use this interface to interact with the API endpoints, view available operations, and see request/response details.
To access Swagger UI, run the application and navigate to: http://localhost:8080/swagger-ui/index.html

Here, you can explore the API endpoints, try out different operations, and view detailed API documentation. If you have any questions, issues, or feedback about this project, please feel free to reach out to me. I'll be happy to assist you!

