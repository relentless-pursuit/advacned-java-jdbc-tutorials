# JDBC Transaction Management

This repository contains a Java program demonstrating JDBC transaction management. It simulates a money transfer between two bank accounts with a preliminary check for sufficient balance before proceeding with the transaction. Database configuration details are conveniently managed using a `config.properties` file.

## Features

- JDBC transaction management: If either operation (withdrawal or deposit) fails, the entire transaction is rolled back to maintain data integrity.

- Balance check: Prior to withdrawing money from an account, the program checks if the account has sufficient funds.

- Properties file configuration: The program uses a `config.properties` file for managing database configuration details, making the program more flexible and easier to configure.

## How to Use

1. Clone the repository to your local machine.
2. Update the `config.properties` file with your database connection details.
3. Run the `TestTransaction.java` file in your Java IDE or from the command line.

Remember, this is a basic implementation and does not handle all edge cases. Please ensure to adapt and expand the code as per your requirements when using it in a production environment.