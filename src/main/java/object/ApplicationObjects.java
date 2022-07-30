package object;

import entity.League;
import list.ClubList;

import java.util.Scanner;

public class ApplicationObjects {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClubList soccerClubs = new ClubList();
    private static final League soccerLeague = new League(soccerClubs);
    private static final ClubList volleyballClubs = new ClubList();
    private static final League volleyballLeague = new League(volleyballClubs);

    private ApplicationObjects() {
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
