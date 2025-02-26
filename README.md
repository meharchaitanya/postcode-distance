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

### Contact
For questions or feedback, please contact:

Name : Mehar Chaitanya
Email: meharchaitanya@gmail.com


