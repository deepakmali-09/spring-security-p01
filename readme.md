# Spring Security Basic Project

## Description
This project demonstrates the implementation of basic authentication and authorization using Spring Security. It showcases how to secure RESTful APIs, configure access permissions, and use authentication mechanisms like form login and HTTP Basic authentication.

## Features
- **Authentication:** Ensures that only authorized users can access protected endpoints.
- **Authorization:** Configures public and secured routes with role-based access.
- **REST API Endpoints:**
    - Publicly accessible endpoints.
    - Secured endpoints requiring authentication.
- **Custom Configuration:** Uses `SecurityFilterChain` to define security configurations.

## Technologies Used
- **Java**: Programming language used for the backend.
- **Spring Boot**: Framework for building the application.
- **Spring Security**: Handles authentication and authorization.
- **Maven**: Dependency management.

## Project Structure
```
src/main/java
├── com.deep.SpringSecurity-p01
│   ├── config
│   │   └── WebConfig.java
│   ├── controller
│   │   └── MyController.java
│   └── SpringSecurityP01Application.java
```

- **WebConfig.java**: Configures security settings, defines public and secured endpoints.
- **ApiController.java**: Contains REST API endpoints.
- **SpringSecurityApplication.java**: Main class to bootstrap the application.

## Endpoints
| Endpoint     | Method | Access         |
|--------------|--------|----------------|
| `/updates`   | GET    | Public         |
| `/contact`   | GET    | Public         |
| `/secure`    | GET    | Secured (Login Required) |

## Configuration Highlights
- **Security Configuration**:
  ```java
  @Configuration
  @EnableWebSecurity
  public class WebConfig {

      @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
          httpSecurity.authorizeHttpRequests(req ->
                  req.requestMatchers("/contact", "updates").permitAll()
                     .anyRequest().authenticated()
          ).formLogin(withDefaults())
            .httpBasic(withDefaults());

          return httpSecurity.build();
      }
  }
  ```

- Public endpoints (`/contact`, `/updates`) are accessible without authentication.
- All other endpoints require authentication.

## Setup and Run
1. **Clone the repository:**
   ```bash
   git clone https://github.com/deepakmali-09/spring-security-p01.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd spring-security-p01
   ```

3. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the APIs:**
    - Open your browser or Postman.
    - Test public endpoints (e.g., `http://localhost:8080/updates`).
    - Test secured endpoints (e.g., `http://localhost:8080/secure`) after logging in.

## Future Enhancements
- Add user roles and role-based access control.
- Implement JWT-based authentication.
- Configure database-backed user authentication.

---
Feel free to fork and contribute to this project!
