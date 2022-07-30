package menu;

import entity.League;
import object.ApplicationObjects;

import java.util.Objects;

public class LeaguesMenu {

    public static void showMenu(League league){
        System.out.println("1) View table");
        System.out.println("2) View information about a club");
        System.out.println("3) Add club");
        System.out.println("4) Remove club");
        System.out.println("5) Add game");
        System.out.println("6) Exit");
        System.out.print("Choose on of the items: ");
        String input = ApplicationObjects.getScanner().next();
        if(Objects.equals(input, "1")){

        } else if(Objects.equals(input, "2")){

        } else if(Objects.equals(input, "3")){

        } else if(Objects.equals(input, "4")){

        } else if(Objects.equals(input, "5")){

        } else if(Objects.equals(input, "6")){

        }
    }

}
