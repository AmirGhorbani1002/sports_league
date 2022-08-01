package object;

import entity.League;
import list.ClubList;
import service.UserMethods;
import service.UserService;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationObjects {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClubList persianSoccerClubPremierClubs = new ClubList();
    private static final League persianSoccerClubPremier = new League(persianSoccerClubPremierClubs);
    private static final ClubList persianVolleyballClubPremierClubs = new ClubList();
    private static final League persianVolleyballClubPremier = new League(persianVolleyballClubPremierClubs);
    private static final UserService userService = new UserService();
    private static final UserMethods userMethods = new UserMethods();

    private ApplicationObjects() {
    }

    public static Scanner getScanner() {
        return scanner;
    }
    public static League getPersianSoccerClubPremier(){return persianSoccerClubPremier;}
    public static ClubList getPersianSoccerClubPremierClubs(){return persianSoccerClubPremierClubs;}
    public static League getPersianVolleyballClubPremier(){return persianVolleyballClubPremier;}
    public static ClubList getPersianVolleyballClubPremierClubs(){ return persianVolleyballClubPremierClubs; }
    public static UserService getUserService(){return userService;}
    public static UserMethods getUserMethods(){return userMethods;}

}
