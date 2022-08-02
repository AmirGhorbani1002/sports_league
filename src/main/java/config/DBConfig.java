package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static final Connection connection;

    public DBConfig() {
    }

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" +
                    "league?currentSchema=public", "postgres", "@MIRr@9137#!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
