package entity;

import list.ClubList;

public class League {

    private final ClubList clubs;
    private final String name;

    public League(String name,ClubList clubs) {
        this.name = name;
        this.clubs = clubs;
    }

    public ClubList getClubs() {
        return clubs;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return null;
    }

}
