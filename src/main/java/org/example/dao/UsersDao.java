package org.example.dao;

import org.example.entity.Users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
    void insert(Users users) throws SQLException, IOException;

    List<Users> getAll() throws SQLException, IOException;

   // Users getById(Long id) throws SQLException, IOException;

    Users findByAlias(String name) throws SQLException, IOException;

    void update(Users users) throws SQLException, IOException;

    void remove(Users users) throws SQLException, IOException;
}
