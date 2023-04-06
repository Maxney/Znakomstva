package org.example.dao;

import org.example.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
    void insert(Users users) throws SQLException;

    List<Users> getAll() throws SQLException;

    Users get(long id) throws SQLException;

    Users getById(Long id) throws SQLException;

    Users findByAlias(String name) throws SQLException;

    void update(Users users) throws SQLException;

    void remove(Users users) throws SQLException;
}
