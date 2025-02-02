
# Student Management System

The **Student Management System** is a Spring Boot-based application designed to manage student records efficiently. It allows users to perform CRUD operations (Create, Read, Update, Delete) on student data. The system utilizes **Spring MVC**, **Hibernate**, and **MySQL** for seamless database interactions.

## 🚀 Features

- 📝 **Add new students**
- 🏷️ **Update student details**
- ❌ **Delete students**
- 🗋 **View all students**
- 🔍 **Search students by ID**

## 🛠️ Tech Stack

- **Java** (JDK 17+)
- **Spring Boot** (2.x or 3.x)
- **Spring Data JPA** (Hibernate)
- **MySQL** (Database)
- **Maven** (Dependency Management)
- **Lombok** (Optional for reducing boilerplate code)

## 💡 Prerequisites

Before running the project, ensure you have the following installed:

- ✅ **Java 17+**
- ✅ **MySQL Server** running on localhost:3306
- ✅ **Maven** installed (run `mvn -version` to check)
- ✅ **IDE** (IntelliJ, Eclipse, or VS Code)

## 🛀 Database Setup

1. Open MySQL Workbench or Command Line.
2. Create the database:

   ```sql
   CREATE DATABASE student_tracker;
   ```

3. Open `src/main/resources/application.properties` and configure the following:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
 
   ```
   ### SQL Scripts for Database Setup

    #### Step 1: Drop and Create MySQL User
    sql
   ```
    -- Drop user first if they exist
    DROP USER if exists 'springstudent'@'%' ;
    
    -- Now create user with proper privileges
    CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';
    
    GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
    select * from springstudent;
   ```
   
    #### Step 2: Create Database and Table
   sql
   ```
    
    -- Create the database if not exists
    CREATE DATABASE IF NOT EXISTS student_tracker;
    USE student_tracker;
    
    -- Table structure for table student
    --
    DROP TABLE IF EXISTS student;
    
    CREATE TABLE student (
      id int NOT NULL AUTO_INCREMENT,
      first_name varchar(45) DEFAULT NULL,
      last_name varchar(45) DEFAULT NULL,
      email varchar(45) DEFAULT NULL,
      PRIMARY KEY (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
    ```

## 🚀 Running the Project Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/student-management-system.git
   cd student-management-system
   ```

2. Open the project in **IntelliJ**, **Eclipse**, or your preferred IDE and ensure Maven dependencies are loaded.
3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Access the application:
   - **REST API**: Open [http://localhost:8080/students](http://localhost:8080/students) in Postman or a browser.

## 🌐 API Endpoints

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| **GET**    | `/students`        | Get all students          |
| **GET**    | `/students/{id}`   | Get student by ID         |
| **POST**   | `/students`        | Add a new student         |
| **PUT**    | `/students/{id}`   | Update student details    |
| **DELETE** | `/students/{id}`   | Delete a student          |

## 🌄 Folder Structure


01-cruddemo-student/
│── src/main/java/com/luv3code/cruddemo/
│   │── dao/StudentDAO.java
│   │── dao/StudentDAOImp.java
│   │── entity/Student.java
│   │── CrudDemoApplication.java
│── src/main/resources/application.properties
│── pom.xml
│── README.md


## 🏢 Deployment Guide

To deploy this project on another system:

1. Ensure **Java**, **MySQL**, and **Maven** are installed.
2. Clone the project from GitHub.
3. Update the `application.properties` file with the correct database credentials.
4. Run using:

   ```bash
   mvn spring-boot:run
   ```

## 🎯 Author

👤 GunaShekar Undabatla
🔗 [GitHub Profile](github.com/gunashekar22)

## 🌟 Happy Coding! 🌟
