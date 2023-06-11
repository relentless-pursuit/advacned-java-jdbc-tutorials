import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {

        // Connection parameters
        String url = "<your DB_URL>";
        String username = "<your DB_username>";
        String password = "<your DB_password>";

        try {
            // Load and register the Driver (optional since JDBC 4.0)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                // Create a statement object to perform SQL queries
                try (Statement statement = connection.createStatement()) {

                    // SQL SELECT query
                    String sqlSelectQuery = "SELECT * FROM employee";

                    // Execute the SQL query
                    try (ResultSet resultSet = statement.executeQuery(sqlSelectQuery)) {

                        // Process the result set
                        System.out.println("ID\tNAME\tROLE\tSALARY");
                        while (resultSet.next()) {
                            Integer id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            String role = resultSet.getString("role");
                            Double salary = resultSet.getDouble("salary");
                            System.out.println(id + "\t" + name + "\t" + role + "\t" + salary);
                        }
                    }
                }
            }

            System.out.println("Closing the connection...");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path ");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
