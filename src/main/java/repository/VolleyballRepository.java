package repository;

import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VolleyballRepository {

    public void save(VolleyballClub volleyballClub) throws SQLException {
        String query = """
                insert into persian_club_premier(code, name, game, win, lose, score,create_date)
                values (?,?,?,?,?,?,?);
                """;
        PreparedStatement preparedStatement = ApplicationObjects
                .getPersianVolleyballClubPremierConnection().prepareStatement(query);
        preparedStatement.setString(1, volleyballClub.getCode());
        preparedStatement.setString(2, volleyballClub.getName());
        preparedStatement.setInt(3, volleyballClub.getNumberOfGamesPlayed());
        preparedStatement.setInt(4, volleyballClub.getNumberOfWins());
        preparedStatement.setInt(5, volleyballClub.getNumberOFLosses());
        preparedStatement.setInt(6, volleyballClub.getScore());
        preparedStatement.setDate(7, volleyballClub.getCreateDate());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public ResultSet load() throws SQLException {
        String query = """
                select * from persian_club_premier;
                """;
        Statement statement = ApplicationObjects
                .getPersianVolleyballClubPremierConnection().createStatement();
        return statement.executeQuery(query);
    }

}
