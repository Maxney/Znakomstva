package org.example.dao;

import org.example.entity.LikeUser;
import org.example.entity.Users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LikeUserDao {
    void insert(LikeUser likeUser) throws SQLException, IOException;

    List<LikeUser> getAll() throws SQLException, IOException;

    LikeUser getById(Long id) throws SQLException, IOException;

    void update(LikeUser likeUser) throws SQLException, IOException;

    void remove(LikeUser likeUser) throws SQLException, IOException;
}
