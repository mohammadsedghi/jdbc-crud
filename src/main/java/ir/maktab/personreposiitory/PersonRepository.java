package ir.maktab.personreposiitory;

import ir.maktab.connection.JdbcConnection;
import ir.maktab.entity.Person;

import java.sql.*;

public class PersonRepository {
    public void save(Person person) throws SQLException {
        final String QUERY1 = "insert into person( name, family) VALUES (?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setString(1, person.getName());
        statement.setString(2, person.getFamily());
        statement.execute();
        System.out.println("commit in the database");
    }


    public void update(Person person) throws Exception {
        final String QUERY1 = "update person set family=? where id=? ";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(2, person.getId());
        statement.setString(1, person.getFamily());
        statement.execute();
        System.out.println("update");
    }

    public void delete(int personId) throws SQLException {
        final String QUERY1 = "delete from person where id = ?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, personId);
        statement.execute();
        System.out.println("delete");
    }

    public Person load(int personId) throws Exception {
        Person person = new Person();
        final String QUERY1 = "select * from person where id=?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, personId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setFamily(resultSet.getString("family"));
        return person;
    }

    public Person[] loadAll() throws Exception {
        final String QUERY1 = "select * from person ";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery();
        int size = 0;
        resultSet.last();
        size = resultSet.getRow();
        resultSet.beforeFirst();
        Person[] persons = new Person[size];
        int i = 0;
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            persons[i++] = person;
        }
        return persons;
    }

    public void saveAll(Person[] person) throws Exception {
        final String QUERY1 = "insert into person( name, family) VALUES (?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        for (int i = 0; i < person.length; i++) {
            statement.setString(1, person[i].getName());
            statement.setString(2, person[i].getFamily());
            statement.addBatch();
        }
        statement.executeBatch();
        System.out.println("commit in the database");
    }

    public int save1(Person person) throws SQLException {
        final String QUERY1 = "insert into person( name, family) VALUES (?,?)";

        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1,Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, person.getName());
        statement.setString(2, person.getFamily());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt("id");
        System.out.println("commit in the database");

       return id;
    }
}

//connection.prepareStatement(sql,
//        ResultSet.TYPE_SCROLL_INSENSITIVE,
//        ResultSet.CONCUR_READ_ONLY);
//query = "SELECT * FROM Person WHERE username ='"+username+"'";
//        rs = stmt.executeQuery(query);
//        ResultSetMetaData metaData = rs.getMetaData();
//        rowcount = metaData.getColumnCount();