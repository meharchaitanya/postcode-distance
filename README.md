# Postcode Distance Microservice
This is a Spring Boot-based microservice that calculates the geographic distance between two UK postcodes using their latitude and longitude coordinates.
The service retrieves postcode data from a PostgreSQL database and returns the distance in kilometers.

### Features
* RESTful API to calculate the distance between two postcodes.
* Stores postcode data (postcode, latitude, longitude) in a PostgreSQL database.
* Returns the distance in kilometers along with the postcode details.
* Supports Java 8 and above.
* Uses Spring Data JPA for database interaction.
* Includes unit and integration tests.

### Technologies Used
* Spring Boot: Backend framework.
* PostgreSQL: Database for storing postcode data.
* Spring Data JPA: For database operations.
* Maven: Build tool.
* Hibernate: ORM framework.
* JUnit: For unit and integration testing.

### Prerequisites
* Java 8 or higher.
* Maven 3.x.
* PostgreSQL installed and running.
* IDE (IntelliJ IDEA, Eclipse, etc.).

### Setup Instructions
1. Clone the Repository
* git clone https://github.com/meharchaitanya/postcode-distance.git

cd postcode-distance
2. Set Up PostgreSQL Database
    * Create a new database in PostgreSQL:

             CREATE DATABASE postcode_db;

    * Create the postcodes table:

                CREATE TABLE postcodes (
                    id SERIAL PRIMARY KEY,
                    postcode VARCHAR(255) NOT NULL UNIQUE,
                    latitude DOUBLE PRECISION NOT NULL,
                    longitude DOUBLE PRECISION NOT NULL
                );
          * Insert sample data:

                  INSERT INTO postcodes (postcode, latitude, longitude) VALUES ('AB101', 57.144165, -2.114848);
                  INSERT INTO postcodes (postcode, latitude, longitude) VALUES ('AB115', 57.147701, -2.095397);
3. #### Configure the Application
   Update the application.properties file with your PostgreSQL database credentials:

           spring.datasource.url=jdbc:postgresql://localhost:5432/postcode_db
           spring.datasource.username=your_username
           spring.datasource.password=your_password
           spring.jpa.hibernate.ddl-auto=update
           spring.jpa.show-sql=true
           spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Running with Docker
1. Build the Docker Image
   Build your Spring Boot application JAR file:

         mvn clean package
         
         Build the Docker image:
         docker build -t postcode-distance .
   2. Run the Docker Container
      Run the Docker container using the following command:

            docker run -p 8080:8080 postcode-distance
            Your Spring Boot application will now be running inside a Docker container, and you can access it at: http://localhost:8080
      3. Docker Compose (Optional)
         If you want to run both your application and PostgreSQL in Docker, you can use Docker Compose.
               Create a docker-compose.yml file in the root of your project:
      
                  version: '3.8'
                  services:
                  postgres:
                  image: postgres:13
                  environment:
                  POSTGRES_DB: postcode_db
                  POSTGRES_USER: your_username
                  POSTGRES_PASSWORD: your_password
                  ports:
                           - "5432:5432"
                           volumes:
                           - postgres-data:/var/lib/postgresql/data
                  app:
                  image: postcode-distance
                  build: .
                  ports:
                  - "8080:8080"
                  environment:
                  SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/postcode_db
                  SPRING_DATASOURCE_USERNAME: your_username
                  SPRING_DATASOURCE_PASSWORD: your_password
                  depends_on:
                    - postgres
                  
                  volumes:
                  postgres-data:

Build and run the Docker Compose setup:

         docker-compose up --build
         Access your application and Swagger UI at:


4. Build the Project
   Run the following command to build the project:
                     
         mvn clean install
   5. Run the Application
      Start the Spring Boot application:

            mvn spring-boot:run
      The application will start on http://localhost:8080.

### API Documentation
Calculate Distance
Endpoint: GET /distance

Parameters:

* postcode1: First postcode.
* postcode2: Second postcode.

#### Example Request:

* GET /distance?postcode1=L36&postcode2=AB115
  Example Response:

json
Copy
{
"postcode1": "L36",
"latitude1": 57.144165,
"longitude1": -2.114848,
"postcode2": "AB115",
"latitude2": 57.147701,
"longitude2": -2.095397,
"distance": 1.23,
"unit": "km"
}
## Project Structure

            src/main/java
            └── com
                └── mehar
                    └── postcode
                        ├── controller
                        │   └── DistanceController.java
                        ├── service
                        │   └── DistanceService.java
                        ├── repository
                        │   └── PostcodeRepository.java
                        ├── model
                        │   └── Postcode.java
                        ├── dto
                        │   └── DistanceResponse.java
                        └── PostcodeDistanceApplication.java
            
                    src/main/resources
                    ├── application.properties
                    └── data.sql (optional, for initial data loading)

## Dependencies
* Spring Boot Starter Web
* Spring Data JPA
* PostgreSQL Driver
* Lombok (optional)
* JUnit

### Contributing
Fork the repository.

#### Create a new branch:

git checkout -b feature/your-feature-name
Commit your changes:

git commit -m "Add your feature"
Push to the branch:

git push origin feature/your-feature-name
Open a pull request.

### Contact
For questions or feedback, please contact:

Name : Mehar Chaitanya
Email: meharchaitanya@gmail.com
