package entity;

import list.ClubList;

public class League {

    private ClubList clubs;

    public League() {
    }

    public League(ClubList clubs) {
        this.clubs = clubs;
    }

    public ClubList getClubs() {
        return clubs;
    }

    public void setClubs(ClubList clubs) {
        this.clubs = clubs;
    }
}
