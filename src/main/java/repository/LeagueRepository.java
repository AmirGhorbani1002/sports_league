package repository;

import entity.League;
import object.ApplicationObjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeagueRepository {

    /*public String load(League league) throws SQLException {
        String query = """
                select * from league
                where name = ?;
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1,league.getName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return resultSet.getString("clubs");
        else
            return "";
    }*/

    public String[] load() throws SQLException{
        String[] temp = new String[1000];
        int i = 0;
        String query = """
                select * from league;
                """;
        Statement statement = ApplicationObjects.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            temp[i++] = resultSet.getString("name");
            temp[i++] = resultSet.getString("clubs");
            temp[i++] = resultSet.getString("club_type");
        }
        return temp;
    }

    public void save(String clubs) throws SQLException {
        String query = """
                insert into league(name)
                values (?);
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1,clubs);
        preparedStatement.executeUpdate();
    }

    public void updateClubs(League league,String clubs) throws SQLException {
        String query = """
                update league
                set clubs = ?
                where name = ?;
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1,clubs);
        preparedStatement.setString(2,league.getName());
        preparedStatement.executeUpdate();
    }

}
