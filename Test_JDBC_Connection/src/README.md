# TestConnection JDBC Example

This project contains a simple Java program that connects to a MySQL database using JDBC and retrieves data from `employee` table.

## Setup

1. Make sure you have a MySQL server instance running.
2. Set up a database `EmployeeDB` and a table `employee` in your MySQL instance.
3. Update the database URL, username, and password in the `TestConnection.java` file.

## How to Run

1. Compile the Java file: `javac TestConnection.java`
2. Run the compiled Java program: `java TestConnection`

## What the Program Does

The `TestConnection` program performs the following steps:

1. Loads and registers the MySQL JDBC driver.
2. Establishes a connection with the MySQL database.
3. Creates a `Statement` object to perform SQL queries.
4. Executes a SQL SELECT query to retrieve data from the `employee` table.
5. Prints the retrieved data to the console.
6. Closes the connection to the database.

## Dependencies

This project requires the MySQL JDBC driver (Connector/J). Make sure to include it in your project's classpath.

