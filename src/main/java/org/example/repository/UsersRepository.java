package org.example.repository;

import org.example.dao.UsersDao;
import org.example.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersRepository implements UsersDao {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String SelectByID = "SELECT idusers,age,discription,searchinterests " +
            "FROM users " +
            "WHERE idusers = ?";

    private static final String SelectByAlias = "SELECT idusers,age,discription,searchinterests " +
            "FROM users " +
            "WHERE alias = ?";
    private static final String SelectInsert = "INSERT INTO" +
            "users(idusers,login,password,alias,age,discription,searchinterests) " +
            "VALUES(?,?,?,?,?,?,?)";

    private static final String SelectAll = "SELECT idusers, age, discription,searchinterests FROM users";

    private static final String SelectUpdate = "UPDATE users SET " +
            "idusers = ?," +
            "login = ?," +
            "password = ?," +
            "alias = ?," +
            "age = ?," +
            "discription = ?," +
            "searchinterests = ?";

    private static final String SelectDelete = "DELETE FROM users WHERE id = ?";

    public UsersRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Users get(long id) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getLong("idusers"));
                users.setDiscription(resultSet.getString("discription"));
                List<String> interests = Collections.
                        singletonList(String.valueOf(resultSet.getArray("searchInterests")));
                users.setSearchInterests(interests);
                return users;
            }
        }
        return null;
    }

    @Override
    public void insert(Users users) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectInsert);
            statement.setLong(1, users.getId());
            statement.setString(2, users.getLogin());
            statement.setString(3, users.getPassword());
            statement.setString(4, users.getAlias());
            statement.setInt(5, users.getAge());
            statement.setString(6, users.getDiscription());
            statement.setArray(7, (Array) users.getSearchInterests());
            statement.executeUpdate();
        }
    }


    @Override
    public List<Users> getAll() throws SQLException {
        List<Users> usersList = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                List<String> searchinterests = Collections.
                        singletonList(String.
                                valueOf(statement.getGeneratedKeys().
                                        getArray("searchinterests")));
                Users user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString(" password"),
                        resultSet.getString("alias"),
                        resultSet.getInt("age"),
                        resultSet.getString("disription"),
                        searchinterests);
                usersList.add(user);
            }
        }
        return usersList;
    }

    @Override
    public Users getById(Long id) throws SQLException {
        Users users = null;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                List<String> searchinterests = Collections.
                        singletonList(String.
                                valueOf(statement.getGeneratedKeys().
                                        getArray("searchinterests")));
                users = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString(" password"),
                        resultSet.getString("alias"),
                        resultSet.getInt("age"),
                        resultSet.getString("disription"),
                        searchinterests);
            }

            return users;
        }
    }

    @Override
    public Users findByAlias(String name) throws SQLException {
        Users users = null;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByID);

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                List<String> searchinterests = Collections.
                        singletonList(String.
                                valueOf(statement.getGeneratedKeys().
                                        getArray("searchinterests")));
                users = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString(" password"),
                        resultSet.getString("alias"),
                        resultSet.getInt("age"),
                        resultSet.getString("disription"),
                        searchinterests);
            }

            return users;
        }
    }

    @Override
    public void update(Users users) throws SQLException {

        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectUpdate);
            statement.setLong(1, users.getId());
            statement.setString(2, users.getLogin());
            statement.setString(3, users.getPassword());
            statement.setString(4, users.getAlias());
            statement.setInt(5, users.getAge());
            statement.setString(6, users.getDiscription());
            statement.setArray(7, (Array) users.getSearchInterests());
            statement.executeUpdate();
        }
    }

    @Override
    public void remove(Users users) throws SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SelectDelete);
            preparedStatement.setLong(1, users.getId());
            preparedStatement.executeUpdate();
        }
    }

};
