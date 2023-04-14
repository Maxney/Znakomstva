package org.example.repository;

import org.example.dao.UsersDao;
import org.example.entity.Users;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class  UsersRepository implements UsersDao {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String SelectByID = "SELECT idusers,age,discription,searchinterests " +
            "FROM users " +
            "WHERE idusers = ?";

    private static final String SelectByAlias = "SELECT idusers,login,password,alias,discription,age,searchinterests " +
            "FROM users " +
            "WHERE alias = ?";
    private static final String SelectInsert = "INSERT INTO " +
            "users(login,password,alias,age,discription,searchinterests) " +
            "VALUES(?,?,?,?,?,?)";

    private static final String SelectAll = "SELECT idusers, age, discription,searchinterests FROM users";

    private static final String SelectUpdate = "UPDATE users SET " +
            "idusers = ?," +
            "login = ?," +
            "password = ?," +
            "alias = ?," +
            "age = ?," +
            "discription = ?," +
            "searchinterests = ?";

    private static final String SelectDelete = "DELETE FROM users WHERE idusers = ?";

    public UsersRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void insert(Users users) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectInsert);
            statement.setString(1, users.getLogin());
            statement.setString(2, users.getPassword());
            statement.setString(3, users.getAlias());
            statement.setInt(4, users.getAge());
            statement.setString(5, users.getDiscription());
            Array array=connection.createArrayOf("text",users.getSearchInterests().toArray());
            statement.setArray(6,array);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Users> getAll() throws SQLException, IOException {
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
                        resultSet.getLong("idusers"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("alias"),
                        resultSet.getInt("age"),
                        resultSet.getString("discription"),
                        searchinterests);
                usersList.add(user);
            }
        }
        return usersList;
    }

    @Override
    public Users findByAlias(String name) throws SQLException, IOException {
        Users users = null;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByAlias);

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                List<String> searchinterests = Collections.
                        singletonList(String.
                                valueOf(resultSet.getArray("searchinterests")));
                users = new Users(
                        resultSet.getLong("idusers"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("alias"),
                        resultSet.getInt("age"),
                        resultSet.getString("discription"),
                        searchinterests);
            }

            return users;
        }
    }

    @Override
    public void update(Users users) throws SQLException, IOException {

        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectUpdate);
            statement.setLong(1, users.getId());
            statement.setString(2, users.getLogin());
            statement.setString(3, users.getPassword());
            statement.setString(4, users.getAlias());
            statement.setInt(5, users.getAge());
            statement.setString(6, users.getDiscription());
            Array array=connection.createArrayOf("text",users.getSearchInterests().toArray());
            statement.setArray(7, array);
            statement.executeUpdate();
        }
    }

    @Override
    public void remove(Users users) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SelectDelete);
            preparedStatement.setLong(1, users.getId());
            preparedStatement.executeUpdate();
        }
    }
};
