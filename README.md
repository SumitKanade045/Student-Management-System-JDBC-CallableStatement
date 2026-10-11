# Student Management System Using JDBC CallableStatement

## Project Overview
The Student Management System is a console-based Java application that manages student records using JDBC and MySQL stored procedures. It allows users to create a table, insert records, update student names, view data, delete records, and drop the student table.

## Technologies Used
- Core Java
- JDBC (Java Database Connectivity)
- MySQL
- `CallableStatement`
- `ResultSet`
- `Statement`
- Stored Procedures
- Exception Handling

## Project Structure
```text
Student-Management-System/
└── src/
    ├── com/
    │   ├── client/
    │   │   └── StudentTest.java
    │   ├── serviceI/
    │   │   └── Requirement.java
    │   └── serviceImpl/
    │       └── ServiceImpl.java
    └── README.md
```

## Features
1. Create the student table and display its structure.
2. Insert student records.
3. Update a student's name using their roll number.
4. View student data and available tables.
5. Delete a student record using their roll number.
6. Delete the complete student table.

## Student Information
- Roll Number
- Name
- City
- Email ID

## Database Configuration
- Database name: `callablestatement`
- MySQL port: `3308`
- Username: `root`

Update the database connection settings in `ServiceImpl.java` according to your MySQL configuration.

## Stored Procedures
The Java application calls the following stored procedures:

- `createtableandsdesctable()` — creates the table and displays its structure.
- `insetandselect(?,?,?,?)` — inserts student data and returns student details.
- `upadteshow(?,?)` — updates and displays student information.
- `getalldatanadshowtables()` — displays table names and student data.
- `deleteandshowrollno(?)` — deletes a student record and displays the roll number.

These procedure names are taken from the Java code and must match the procedures defined in your MySQL database.

## How to Run
1. Install Java and MySQL.
2. Create the `callablestatement` database.
3. Create the required stored procedures in MySQL.
4. Add the MySQL Connector/J library to your Java project.
5. Configure the database URL, username, and password.
6. Run `StudentTest.java`.
7. Select an operation from the console menu.

## Learning Outcomes
- Understanding JDBC database connectivity.
- Executing MySQL stored procedures using `CallableStatement`.
- Working with `ResultSet` and SQL statements.
- Performing CRUD operations.
- Handling database exceptions.

## Author
Java Developer Fresher
