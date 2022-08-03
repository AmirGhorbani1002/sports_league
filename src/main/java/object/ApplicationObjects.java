package object;

import config.DBConfig;
import entity.League;
import util.ClubList;
import repository.LeagueRepository;
import util.ConvertClubString;
import service.UserMethods;
import service.UserService;
import util.LeagueList;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationObjects {

    private static final Scanner scanner = new Scanner(System.in);
    /*private static final ClubList persianSoccerClubPremierClubs = new ClubList();
    private static final League persianSoccerPremierLeague = new League("persianSoccerPremierLeague", persianSoccerClubPremierClubs);
    private static final ClubList persianVolleyballClubPremierClubs = new ClubList();
    private static final League persianVolleyballPremierLeague = new League("persianVolleyballPremierLeague", persianVolleyballClubPremierClubs);*/

    private static final LeagueList leagueList = new LeagueList();
    private static final UserService userService = new UserService();
    private static final UserMethods userMethods = new UserMethods();
    private static final Connection connection = DBConfig.getConnection();
    private static final LeagueRepository leagueRepository = new LeagueRepository();
    private static final ConvertClubString clubToString = new ConvertClubString();

    private ApplicationObjects() {
    }

    public static Scanner getScanner() {
        return scanner;
    }

    /*public static League getPersianSoccerPremierLeague() {
        return persianSoccerPremierLeague;
    }


    public static League getPersianVolleyballPremierLeague() {
        return persianVolleyballPremierLeague;
    }*/

    public static LeagueList getLeagueList() {
        return leagueList;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static UserMethods getUserMethods() {
        return userMethods;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static LeagueRepository getLeagueRepository() {
        return leagueRepository;
    }

    public static ConvertClubString getClubToString() {
        return clubToString;
    }
}
