package entity;

import enums.GameResult;

import java.sql.Date;
import java.util.Objects;

public abstract class Club {

    private final String name;
    private final int numberOfPlayers;
    private final String code;
    private final Date createDate;
    private int score;
    private int numberOfGamesPlayed;
    private int numberOfWins;
    private int numberOFLosses;

    public Club(String name, int numberOfPlayers, String code) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.code = code;
        this.score = 0;
        this.numberOfGamesPlayed = 0;
        this.numberOfWins = 0;
        this.numberOFLosses = 0;
        this.createDate = Date.valueOf(java.time.LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getCode() {
        return code;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public void setNumberOfGamesPlayed(int numberOfGamesPlayed) {
        this.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOFLosses() {
        return numberOFLosses;
    }

    public void setNumberOFLosses(int numberOFLosses) {
        this.numberOFLosses = numberOFLosses;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(name, club.name) || Objects.equals(code, club.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
