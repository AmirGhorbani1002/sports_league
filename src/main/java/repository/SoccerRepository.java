package repository;

import entity.SoccerClub;
import object.ApplicationObjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SoccerRepository {

    public void save(SoccerClub soccerClub) throws SQLException {
        String query = """
                insert into persian_club_premier(code, name, game, win, lose, draw, score,create_date)
                values (?,?,?,?,?,?,?,?);
                """;
        PreparedStatement preparedStatement = ApplicationObjects
                .getPersianSoccerClubPremierConnection().prepareStatement(query);
        preparedStatement.setString(1, soccerClub.getCode());
        preparedStatement.setString(2, soccerClub.getName());
        preparedStatement.setInt(3, soccerClub.getNumberOfGamesPlayed());
        preparedStatement.setInt(4, soccerClub.getNumberOfWins());
        preparedStatement.setInt(5, soccerClub.getNumberOFLosses());
        preparedStatement.setInt(6, soccerClub.getNumberOfDraws());
        preparedStatement.setInt(7, soccerClub.getScore());
        preparedStatement.setDate(8, soccerClub.getCreateDate());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public ResultSet load() throws SQLException {
        String query = """
                select * from persian_club_premier;
                """;
        Statement statement = ApplicationObjects
                .getPersianSoccerClubPremierConnection().createStatement();
        return statement.executeQuery(query);
    }

}
