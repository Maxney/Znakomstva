import org.example.entity.Users;
import org.example.repository.ConnectionFactory;
import org.example.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class UsersTest {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    private final UsersRepository usersRepository = new UsersRepository(connectionFactory);

    List<String> searchInterests=new ArrayList<>(Arrays.asList("first","second"));
    Users user = new Users(
            null,
            "login","password,","alias",19,"discription",searchInterests);
    /*@BeforeEach
    public static void dropDb() throws IOException, SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            String dropDb="DROP TABLE if exists userphoto,users,likeuser CASCADE ";
            PreparedStatement statement = connection.prepareStatement(dropDb);
            statement.executeUpdate(dropDb);
        }
    }

     */
    @Test
    public void insertAndGetById() throws SQLException, IOException {

        usersRepository.insert(user);
        Users foundUser = usersRepository.findByAlias(user.getAlias());
        assertEquals(user, foundUser);
    }
    @Test
    public void removeUsers() throws SQLException, IOException {
        usersRepository.insert(user);
        Users foundUser = usersRepository.findByAlias(user.getAlias());
        usersRepository.remove(foundUser);
        assertNull(usersRepository.findByAlias(user.getAlias()));
    }
    @Test
    public void updateUser() throws SQLException, IOException {
        usersRepository.insert(user);
        List<String> searchInterestsnew=new ArrayList<>(Arrays.asList("1","2"));
        Users updateUser = new Users(
                usersRepository.findByAlias(user.getAlias()).getId(), "logiiin",
                "passwordnew", "aliasnew", 35,"discription_new",searchInterestsnew);

        usersRepository.update(updateUser);
        assertEquals(updateUser, usersRepository.findByAlias(updateUser.getAlias()));

        usersRepository.remove(usersRepository.findByAlias(updateUser.getAlias()));
    }
    @Test
    public void getAllUsers() throws SQLException, IOException {
        List<Users> usersList = usersRepository.getAll();
        usersList.stream().forEach(System.out::println);
    }
}
