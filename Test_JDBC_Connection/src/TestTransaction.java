import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TestTransaction {

    public static void main(String[] args) {

        Properties prop = new Properties();
        try (InputStream input = TestTransaction.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            // Load a properties file from class path
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(
            prop.getProperty("url"), 
            prop.getProperty("user"), 
            prop.getProperty("password"))) {

            System.out.println("Connected to the database.");

            // Amount to be transferred
            double transferAmount = 500.00;

            // Start transaction
            connection.setAutoCommit(false);

            // Check balance of account 1
            PreparedStatement checkBalanceStmt = connection.prepareStatement("SELECT Balance FROM BankAccount WHERE ID = ?");
            checkBalanceStmt.setInt(1, 1);
            ResultSet rs = checkBalanceStmt.executeQuery();
            
            if (rs.next()) {
                double balance = rs.getDouble(1);

                // Proceed if balance is sufficient
                if (balance >= transferAmount) {
                    // Take transferAmount from account 1
                    PreparedStatement updateAccount1Stmt = connection.prepareStatement("UPDATE BankAccount SET Balance = Balance - ? WHERE ID = ?");
                    updateAccount1Stmt.setDouble(1, transferAmount);
                    updateAccount1Stmt.setInt(2, 1);
                    updateAccount1Stmt.executeUpdate();

                    // Add transferAmount to account 2
                    PreparedStatement updateAccount2Stmt = connection.prepareStatement("UPDATE BankAccount SET Balance = Balance + ? WHERE ID = ?");
                    updateAccount2Stmt.setDouble(1, transferAmount);
                    updateAccount2Stmt.setInt(2, 2);
                    updateAccount2Stmt.executeUpdate();

                    // Commit transaction
                    connection.commit();
                    
                    // Print data after transaction
                    PreparedStatement selectStmt = connection.prepareStatement("SELECT ID, Balance FROM BankAccount");
                    ResultSet resultSet = selectStmt.executeQuery();
                    
                    System.out.println("Data after transaction:");
                    while(resultSet.next()) {
                        System.out.println("Account ID: " + resultSet.getInt(1) + ", Balance: " + resultSet.getDouble(2));
                    }

                    System.out.println("Transaction success.");
                } else {
                    System.out.println("Insufficient balance. Transaction failed.");
                    connection.rollback();
                }
            }

        } catch (SQLException ex) {

            System.out.println("An error occurred. Transaction is being rolled back.");
            ex.printStackTrace();

        }
    }
}
