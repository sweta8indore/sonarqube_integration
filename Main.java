import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Hardcoded credentials
    private static final String USER = "admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo",
                    USER,
                    PASSWORD);

            Statement stmt = conn.createStatement();

            // SQL Injection
            String query = "SELECT * FROM users WHERE username='" + username + "'";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (Exception e) {
            // Empty catch block
        }

        // Weak random
        Random random = new Random();
        System.out.println(random.nextInt());

        // Null Pointer risk
        String text = null;
        System.out.println(text.length());

    }

    public void duplicate1() {
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
    }

    public void duplicate2() {
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
    }
}