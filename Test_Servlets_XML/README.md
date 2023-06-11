# Servlet Lifecycle Example

This repository contains an example Java servlet demonstrating the lifecycle methods and XML configuration.

## Servlet Code

The servlet code is located in the `myproject.servlets` package and consists of a `LifecycleServlet` class that extends `HttpServlet`. It implements the `init()`, `doGet()`, and `destroy()` methods to demonstrate the servlet lifecycle.

## XML Configuration

The servlet is configured using the `web.xml` file located in the root of the project. The `web.xml` file defines the servlet and its mapping to a URL pattern.

## Usage

To use this example, you can follow these steps:

1. Set up a Java web application environment (e.g., Apache Tomcat server).
2. Place the servlet code in the appropriate package (`myproject.servlets`).
3. Create the `web.xml` file and configure the servlet and its mapping.
4. Build and deploy the application to your web server.
5. Access the servlet using the specified URL pattern (e.g., `/LifecycleServlet`).

Feel free to modify and experiment with the code to explore the servlet lifecycle and XML configuration.
