package util;

import entity.Club;
import entity.League;

import java.util.Arrays;
import java.util.Objects;

public class LeagueList {

    private League[] leagues = new League[1000];
    private int index = 0;

    public League[] getLeagues() {
        return leagues;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLeagues(League[] leagues) {
        this.leagues = leagues;
    }

    public void add(League league) {
        if (index > 999)
            leagues = Arrays.copyOf(leagues, index + 1000);
        leagues[index] = league;
        index++;
    }

    public void remove(String name) {
        int i = 0;
        for (League league : leagues) {
            if (Objects.equals(league.getName(), name)) {
                break;
            }
            i++;
        }
        if (index - i >= 0)
            System.arraycopy(leagues, i + 1, leagues, i, index - i);
    }

}
