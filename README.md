# URL Shortener

This project is a URL Shortener service that allows users to shorten URLs, retrieve the original URLs from shortened codes, and track statistics such as access counts. It is built using Spring Boot, JPA for persistence, and provides RESTful APIs for interacting with the service.

## Features

- **Shorten URL**: Accepts a full URL and generates a shortened code.
- **Retrieve Original URL**: Given a shortened code, returns the original URL.
- **Redirect to Original URL**: Automatically redirects to the original URL when the shortened code is accessed.
- **URL Statistics**: Tracks how many times a shortened URL has been accessed.
- **CRUD Operations**: Supports Create, Read, Update, and Delete operations for URL mappings.

## Technologies Used

- **Java 11+**
- **Spring Boot** (REST, JPA, and Transaction Management)
- **Hibernate/JPA** for database interaction
- **PostGres Database**
- **Maven** for dependency management

## Setup Instructions

### Prerequisites

- Java 11 or above
- Maven 3.6 or above

### Steps to Run

1. Clone the repository:

   ```
   git clone https://github.com/your-repo/url-shortener.git
   cd url-shortener

2. Build the project using Maven:

   ```
   mvn clean install

3. Database Configuration

     - Change the portNo and dbName 
     - Change the username and password
  
    ```
    spring.application.name=urlShortener
    spring.datasource.url=jdbc:postgresql://localhost:portNo/dbName
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.generate-ddl=true
3. Run the application:

   ```
   mvn spring-boot:run

## API Endpoints

### 1. Create a Short URL

- **POST** `/api/shorten`
- **Body:** 
  ```json
  {
    "url": "https://example.com"
  }
- **Response:**
  ```
  {
    "id": "abc123",
    "url": "https://example.com",
    "shortCode": "abc123",
    "createdAt": "2024-09-16T12:00:00",
    "updatedAt": "2024-09-16T12:00:00"
  }

### 2. Get Original URL

- **GET** `/api/shorten/abc123`
- **Response:**
  ```
  {
    "createdAt": "2024-09-16T20:59:37.224991",
    "id": "N110M7",
    "url": "https://example.com",
    "shortCode": "N110M7",
    "updatedAt": "2024-09-16T20:59:37.224991"
  }

### 3. Redirect to Original URL

- **GET** `/api/{shortCode}`
- **Response:** Redirects to the original URL with a 302 Found status.

### 4. Update Short URL

- **PUT** `/api/shorten/{shortCode}`
- **Body:** 
    ```
    {
       "url": "https://newurl.com"
    }
- **Response:**
   ```
   {
      "id": "abc123",
      "url": "https://newurl.com",
      "shortCode": "abc123",
      "createdAt": "2024-09-16T12:00:00",
      "updatedAt": "2024-09-17T12:00:00"
   }
   
### 5. Delete Short URL

- **DELETE** `/api/shorten/{shortCode}`
- **Response:** 204 No Content

### 6. Get URL Statistics

- **GET** `/api/shorten/{shortCode}/stats`
- **Response:** 
     ```
     {
        "id": "abc123",
        "url": "https://example.com",
        "shortCode": "abc123",
        "createdAt": "2024-09-16T12:00:00",
        "updatedAt": "2024-09-16T12:00:00",
        "accessCount": 42
     }

