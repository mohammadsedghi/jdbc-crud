package ir.maktab.personreposiitory;

import ir.maktab.entity.Person;
import ir.maktab.personreposiitory.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRepository {
    public  void save(Person person) throws SQLException {
        final String QUERY1 = "insert into person( name, family) VALUES (?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement .setString(1, person.getName());
        statement .setString(2, person.getFamily());
        statement.execute();
        System.out.println("commit in the database");
    }




    public void update(Person person) throws Exception {
        final String QUERY1 ="update person set family=? where id=? ";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement .setInt(2,person.getId());
        statement .setString(1,person.getFamily());
        statement.execute();
        System.out.println("update");
    }
    public void delete(int personId ) throws SQLException {
        final String QUERY1 = "delete from person where id = ?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement .setInt(1,personId);
        statement.execute();
        System.out.println("delete");
    }

}
