package repository;

import entity.League;
import object.ApplicationObjects;
import org.postgresql.plugin.AuthenticationPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeagueRepository {

    public String[] load() throws SQLException {
        String[] temp = new String[1000];
        int i = 0;
        String query = """
                select * from league;
                """;
        Statement statement = ApplicationObjects.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            temp[i++] = resultSet.getString("name");
            temp[i++] = resultSet.getString("clubs");
            temp[i++] = resultSet.getString("club_type");
        }
        statement.close();
        resultSet.close();
        return temp;
    }

    public boolean load(String name) throws SQLException{
        String query = """
                select * from league
                where name = ?;
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            preparedStatement.close();
            resultSet.close();
            return true;
        }else{
            preparedStatement.close();
            resultSet.close();
            return false;
        }
    }

    public void save(String name, String clubType) throws SQLException {
        String query = """
                insert into league(name, clubs, club_type)
                values (?,?,?);
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, null);
        preparedStatement.setString(3, clubType);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(String name) throws SQLException {
        String query = """
                delete from league
                where name = ?;
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateClubs(League league, String clubs) throws SQLException {
        String query = """
                update league
                set clubs = ?
                where name = ?;
                """;
        PreparedStatement preparedStatement = ApplicationObjects.getConnection().prepareStatement(query);
        preparedStatement.setString(1, clubs);
        preparedStatement.setString(2, league.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
