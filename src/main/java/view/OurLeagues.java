package view;

import check.Check;
import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class OurLeagues {

    Leagues leagues = new Leagues();
    Check check = new Check();

    public void showMenu() throws SQLException {
        while (true) {
            int numberOfLeagues = 0;
            String[] type = ApplicationObjects.getUserService().loadAllLeagues();
            System.out.println("We have the following leagues");
            for (int i = 0; i < ApplicationObjects.getLeagueList().getLeagues().length; i++) {
                if (ApplicationObjects.getLeagueList().getLeagues()[i] != null) {
                    System.out.println((i + 1) + ") " + ApplicationObjects.getLeagueList().getLeagues()[i].getName());
                    numberOfLeagues++;
                } else break;
            }
            System.out.println((numberOfLeagues + 1) + ") Add league");
            System.out.println((numberOfLeagues + 2) + ") Delete league");
            System.out.println((numberOfLeagues + 3) + ") Exit");
            System.out.print("Choose one of our leagues or add league: ");
            int input = check.checkLeagueExists(ApplicationObjects.getScanner().next(), numberOfLeagues);
            if (input == numberOfLeagues + 1)
                ApplicationObjects.getUserMethods().addLeague();
            else if (input == numberOfLeagues + 2)
                ApplicationObjects.getUserMethods().deleteLeague();
            else if (input == numberOfLeagues + 3)
                break;
            else
                leagues.showMenu(ApplicationObjects.getLeagueList().getLeagues()[input - 1]
                        , type[input - 1]);
        }
    }
}
