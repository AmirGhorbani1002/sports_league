package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private final static Connection persianVolleyballClubPremier;
    private final static Connection persianSoccerClubPremier;

    private DBConfig() throws SQLException {
    }

    static {
        try {
            persianVolleyballClubPremier = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/league?currentSchema" +
                            "=volleyball","postgres","@MIRr@9137#!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            persianSoccerClubPremier = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/league?currentSchema" +
                            "=soccer","postgres","@MIRr@9137#!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getPersianVolleyballClubPremier(){
        return persianVolleyballClubPremier;
    }

    public static Connection getPersianSoccerClubPremier() {
        return persianSoccerClubPremier;
    }
}
