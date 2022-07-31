package object;

import config.DBConfig;
import entity.League;
import list.ClubList;
import repository.SoccerRepository;
import repository.VolleyballRepository;

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
    private static final SoccerRepository soccerRepository = new SoccerRepository();
    private static final VolleyballRepository volleyballRepository = new VolleyballRepository();

    private ApplicationObjects() {
    }

    public static Scanner getScanner() {
        return scanner;
    }
    public static Connection getPersianSoccerClubPremierConnection(){return persianSoccerClubPremierConnection;}
    public static Connection getPersianVolleyballClubPremierConnection(){return persianVolleyballClubPremierConnection;}
    public static SoccerRepository getSoccerRepository(){return soccerRepository;}
    public static VolleyballRepository getVolleyballRepository(){return volleyballRepository;}
    public static League getPersianSoccerClubPremier(){return persianSoccerClubPremier;}
    public static League getPersianVolleyballClubPremier(){return persianVolleyballClubPremier;}
    public static ClubList getPersianSoccerClubPremierClubs(){return persianSoccerClubPremierClubs;}
    public static ClubList getPersianVolleyballClubPremierClubs(){ return persianVolleyballClubPremierClubs; }

}
