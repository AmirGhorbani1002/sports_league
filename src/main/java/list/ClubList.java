package list;

import entity.Club;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ClubList implements Comparator<Club> {

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

    public void remove(String code) {
        int i = 0;
        for (Club club : clubs) {
            if (Objects.equals(club.getCode(), code)) {
                club = null;
                break;
            }
            i++;
        }
        if (index - i >= 0)
            System.arraycopy(clubs, i + 1, clubs, i, index - i);
    }

    public void remove(Club club) {}

    @Override
    public int compare(Club c1, Club c2) {
        return c1.getScore() - c2.getScore();
    }
}
