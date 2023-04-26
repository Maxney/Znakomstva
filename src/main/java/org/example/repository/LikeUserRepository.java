package org.example.repository;

import org.example.entity.LikeUser;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  LikeUserRepository  {

    public LikeUserRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String SelectByID = "SELECT idlikeuser,iduser,id_photo " +
            "FROM likeuser " +
            "WHERE iduser = ?";

    private static final String SelectInsert = "INSERT INTO " +
            "likeuser(iduser,id_photo) " +
            "VALUES(?,?)";

    private static final String SelectAll = "SELECT idlikeuser,iduser,id_photo " +
            "FROM likeuser ";

    private static final String SelectUpdate = "UPDATE likeuser SET " +
            "idlikeuser = ?," +
            "iduser = ?," +
            "id_photo = ?";

    private static final String SelectDelete = "DELETE FROM likeuser WHERE iduser = ?";

    public void insert(LikeUser likeUser) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectInsert);
            statement.setLong(1, likeUser.getIdUser());
            statement.setLong(2, likeUser.getIdLikePhoto());
            statement.executeUpdate();
        }
    }
    public List<LikeUser> getAll() throws SQLException, IOException {
        List<LikeUser> likeUsers = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LikeUser likeUser = new LikeUser(
                        resultSet.getLong("idlikeuser"),
                        resultSet.getLong("iduser"),
                        resultSet.getLong("id_photo"));
                likeUsers.add(likeUser);
            }
        }
        return likeUsers;
    }
    public LikeUser getById(Long id) throws SQLException, IOException {
        LikeUser likeUser = null;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                likeUser = new LikeUser(
                        resultSet.getLong("idlikeuser"),
                        resultSet.getLong("iduser"),
                        resultSet.getLong("id_photo"));
            }

            return likeUser;
        }
    }
    public void update(LikeUser likeUser) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectUpdate);
            statement.setLong(1, likeUser.getIdLikeUser());
            statement.setLong(2,likeUser.getIdUser());
            statement.setLong(3,likeUser.getIdLikePhoto());
            statement.executeUpdate();
        }
    }

    public void remove(LikeUser likeUser) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SelectDelete);
            preparedStatement.setLong(1, likeUser.getIdUser());
            preparedStatement.executeUpdate();
        }
    }
}
