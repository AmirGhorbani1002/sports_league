package list;

import entity.Club;

import java.util.*;

public class ClubList {

    private Club[] clubs = new Club[1000];
    private int index = 0;

    public ClubList() {
    }

    public ClubList(Club[] clubs) {
        this.clubs = clubs;
    }

    public Club[] getClubs() {
        return clubs;
    }

    public void setClubs(Club[] clubs) {
        this.clubs = clubs;
    }

    public void add(Club club) {
        if (index > 999)
            clubs = Arrays.copyOf(clubs, index + 1000);
        clubs[index] = club;
        index++;
    }

    public void remove(String name) {
        int i = 0;
        for (Club club : clubs) {
            if (Objects.equals(club.getName(), name)) {
                break;
            }
            i++;
        }
        if (index - i >= 0)
            System.arraycopy(clubs, i + 1, clubs, i, index - i);
    }

    public void remove(Club club) {
    }

}
