package org.example.servlet;

import org.example.repository.ConnectionFactory;
import org.example.repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import java.util.Random;


@WebServlet(value="/users", name="users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ConnectionFactory connectionFactory=new ConnectionFactory();
        try {
          connectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UsersRepository usersRepository=new UsersRepository(connectionFactory);
        try {
            req.setAttribute("users", usersRepository.findByAlias("alias").getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.getOutputStream().print(new Random().nextInt());
    }
}
