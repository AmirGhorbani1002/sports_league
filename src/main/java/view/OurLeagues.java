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

    public void showMenu() throws SQLException {
        /*while (true) {
            System.out.println("We have the following leagues");
            System.out.println("1) Persian Soccer Club Premier");
            System.out.println("2) Persian Volleyball Club Premier");
            System.out.println("3) Exit");
            System.out.print("Choose one of our league: ");
            String input = ApplicationObjects.getScanner().next();
            if (Objects.equals(input, "1")) {
                ApplicationObjects.getUserService().loadLeague(ApplicationObjects.getPersianSoccerPremierLeague(),
                        new SoccerClub("a", "a"));
                leagues.showMenu(ApplicationObjects.getPersianSoccerPremierLeague(), new SoccerClub("a", "a"));
            } else if (Objects.equals(input, "2")) {
                ApplicationObjects.getUserService().loadLeague(ApplicationObjects.getPersianVolleyballPremierLeague(),
                        new VolleyballClub("a", "a"));
                leagues.showMenu(ApplicationObjects.getPersianVolleyballPremierLeague(), new VolleyballClub("a", "a"));
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                Check.printMessage("Wrong input");
            }
        }*/
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
            System.out.print("Choose one of our leagues or add league: ");
            int input = Check.checkLeagueExists(ApplicationObjects.getScanner().next(), numberOfLeagues);
            if(input == numberOfLeagues + 1)
                System.out.println("hello");
            else
                leagues.showMenu(ApplicationObjects.getLeagueList().getLeagues()[input - 1]
                    , type[input - 1]);
        }
    }
}
