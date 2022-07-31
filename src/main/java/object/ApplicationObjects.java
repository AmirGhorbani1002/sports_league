package object;

import config.DBConfig;
import entity.League;
import list.ClubList;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationObjects {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Connection persianSoccerClubPremierConnection = DBConfig.getPersianSoccerClubPremier();
    private static final Connection persianVolleyballClubPremierConnection = DBConfig.getPersianVolleyballClubPremier();
    private static final ClubList persianSoccerClubPremierClubs = new ClubList();
    private static final League persianSoccerClubPremier = new League(persianSoccerClubPremierClubs);
    private static final ClubList persianVolleyballClubPremierClubs = new ClubList();
    private static final League persianVolleyballClubPremier = new League(persianVolleyballClubPremierClubs);

    private ApplicationObjects() {
    }

    public static Scanner getScanner() {
        return scanner;
    }
    public static Connection getPersianSoccerClubPremierConnection(){return persianSoccerClubPremierConnection;}
}
