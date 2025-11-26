# 🏛️ Simple JDBC DAO Project (Student Management)

This project demonstrates a basic implementation of the Data Access Object (DAO) pattern in Java using JDBC to perform CRUD (Create, Retrieve, Update, Delete) operations on a MySQL database table named `students`.

## ⚙️ Project Structure

The project follows a standard structure for JDBC-based applications, separating the interface, implementation, utility, and main execution logic.

| File Name | Description |
| :--- | :--- |
| `DaoInterface.java` | A generic interface defining the standard CRUD operations (`getAll`, `getOne`, `create`, `update`, `deleteOne`) for any entity. |
| `Student.java` | The simple POJO (Plain Old Java Object) representing the `Student` entity with fields: `StudentId`, `name`, and `city`. |
| `StudentDao.java` | The concrete implementation of `DaoInterface<Student, Integer>`. It contains the JDBC logic using `Statement` and `PreparedStatement` to interact with the `students` table. |
| `JdbcUtils.java` | A utility class with a static method `getConnection()` to establish and return a database connection, centralizing the connection details (URL, user, password). |
| `DataInsertionMain.java` | Main class to demonstrate the **CREATE** operation (inserting a new `Student` record). |
| `DataUpdateMain.java` | Main class to demonstrate the **UPDATE** operation (retrieving a record, modifying it, and saving the changes). |
| `DataDeletionMain.java` | Main class to demonstrate the **DELETE** operation (removing a `Student` record by ID). |
| `DataRetrievalMain2.java` | Main class to demonstrate the **RETRIEVAL** operations (`getAll` and `getOne` using the DAO). |
| `DataRetrievalMain.java` | A separate example of a direct, non-DAO-based JDBC **RETRIEVAL** using `Statement` for comparison. |

## 🛠️ Technology Stack

* **Language:** Java
* **Database:** MySQL
* **Connectivity:** JDBC (Java Database Connectivity)
* **Design Pattern:** Data Access Object (DAO)

## 🔑 Key Features Demonstrated

* **DAO Pattern:** Separates the business logic from the persistence logic, making the code cleaner and easier to maintain.
* **JDBC Best Practices:**
    * Using `PreparedStatement` for all DML operations (`create`, `update`, `deleteOne`, `getOne`) to prevent SQL injection and improve performance.
    * Using the try-with-resources statement (available since Java 7) in `StudentDao.java` to ensure `Connection`, `Statement`, `PreparedStatement`, and `ResultSet` are automatically closed, preventing resource leaks.
* **Database Connection Utility:** Centralized connection details and handling in `JdbcUtils.java`.

## 🚀 Setup and Configuration

### 1. Database Schema

You must have a MySQL database named `cdac` and a table named `students` configured. The table should align with the fields used in `Student.java` and `StudentDao.java`.

**Required SQL Schema:**

```sql
-- Assuming a database named 'cdac' exists
-- CREATE DATABASE cdac;
-- USE cdac;

CREATE TABLE students (
    stud_id INT PRIMARY KEY,
    stud_name VARCHAR(255),
    studt_city VARCHAR(255)
);
