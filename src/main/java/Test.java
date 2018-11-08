import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nchostel?useSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",username,password);
        } catch (SQLException e2) {
            throw new IllegalStateException("Cannot connect the database!", e2);
        }

    }
}
