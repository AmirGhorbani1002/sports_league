import view.OurLeagues;

import java.sql.SQLException;

public class Main {

    private static final OurLeagues ourLeagues = new OurLeagues();
    public static void main(String[] args) throws SQLException {
        ourLeagues.showMenu();
    }

}
