package entity;

import util.ClubList;

public class League {

    private ClubList clubs;
    private String name;

    public League(String name, ClubList clubs) {
        this.name = name;
        this.clubs = clubs;
    }

    public ClubList getClubs() {
        return clubs;
    }

    public String getName() {
        return name;
    }

    public void setClubs(ClubList clubs) {
        this.clubs = clubs;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return null;
    }

}
