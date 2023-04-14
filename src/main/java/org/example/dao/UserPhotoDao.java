package org.example.dao;

import org.example.entity.UserPhoto;
import org.example.entity.Users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserPhotoDao {
    void insert(UserPhoto userPhoto) throws SQLException, IOException;
    List<UserPhoto> getAll() throws SQLException, IOException;
    UserPhoto getByAdress(String adress) throws SQLException, IOException;
    void update(UserPhoto userPhoto) throws SQLException, IOException;
    void remove(UserPhoto userPhoto) throws SQLException, IOException;
}
