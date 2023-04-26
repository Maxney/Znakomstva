package org.example.repository;

import org.example.entity.UserPhoto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  UserPhotoRepository  {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String SelectByAdress = "SELECT iduserphoto,iduser,adress " +
            "FROM userphoto " +
            "WHERE adress = ?";

    private static final String SelectInsert = "INSERT INTO " +
            "userphoto(iduser,adress) " +
            "VALUES(?,?)";

    private static final String SelectAll = "SELECT iduserphoto,iduser,adress FROM userphoto";

    private static final String SelectUpdate = "UPDATE userphoto SET "+
            "iduser = ?," +
            "adress = ?";

    private static final String SelectDelete = "DELETE FROM userphoto WHERE iduserphoto = ?";

    public UserPhotoRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }


    public void insert(UserPhoto userPhoto) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectInsert);
            statement.setLong(1, userPhoto.getIdUser());
            statement.setString(2, userPhoto.getAdress());
            statement.executeUpdate();
        }
    }
    public List<UserPhoto> getAll() throws SQLException, IOException {
        List<UserPhoto> userPhotos = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               UserPhoto userPhoto = new UserPhoto(
                        resultSet.getLong("iduserphoto"),
                        resultSet.getLong("iduser"),
                        resultSet.getString("adress"));
                userPhotos.add(userPhoto);
            }
        }
        return userPhotos;
    }

    public UserPhoto getByAdress(String adress) throws SQLException, IOException {
        UserPhoto userPhoto = null;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectByAdress);

            statement.setString(1,adress);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userPhoto = new UserPhoto(
                        resultSet.getLong("iduserphoto"),
                        resultSet.getLong("iduser"),
                        resultSet.getString("adress"));
            }

            return userPhoto;
        }
    }


    public void update(UserPhoto userPhoto) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SelectUpdate);
            statement.setLong(1,userPhoto.getIdUser());
            statement.setString(2,userPhoto.getAdress());
            statement.executeUpdate();
        }
    }

    public void remove(UserPhoto userPhoto) throws SQLException, IOException {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SelectDelete);
            preparedStatement.setLong(1, userPhoto.getIdUserPhoto());
            preparedStatement.executeUpdate();
        }
    }
}
