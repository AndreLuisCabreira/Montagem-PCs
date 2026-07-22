import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =
            "jdbc:mysql://localhost:3307/pcbuilder";

    private static final String USER = "root";

    private static final String PASSWORD = "senacrs";

    public static Connection getConexao(){
        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}