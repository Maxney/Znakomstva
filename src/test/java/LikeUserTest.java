import org.example.entity.LikeUser;
import org.example.entity.UserPhoto;
import org.example.repository.ConnectionFactory;
import org.example.repository.LikeUserRepository;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LikeUserTest {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    private final LikeUserRepository likeUserRepository = new LikeUserRepository(connectionFactory);

    LikeUser likeUser = new LikeUser (
            null,2L,19L);

    /*@BeforeEach
    public void dropDb() throws IOException, SQLException {
        try (Connection connection = connectionFactory.getConnection()) {
            String dropDb="DROP TABLE if exists userphoto,users,likeuser CASCADE ";
            PreparedStatement statement = connection.prepareStatement(dropDb);
            statement.executeUpdate(dropDb);
        }
    }
     */
    @Test
    public void insertAndGetById() throws SQLException, IOException {
        likeUserRepository.insert(likeUser);
        LikeUser foundLikeUser = likeUserRepository.getById(likeUser.getIdUser());
        assertEquals(likeUser, foundLikeUser);
    }
    @Test
    public void removeUserLike() throws SQLException, IOException {
        likeUserRepository.insert(likeUser);
        LikeUser foundLikeUser = likeUserRepository.getById(likeUser.getIdUser());
        likeUserRepository.remove(foundLikeUser);
        assertNull(likeUserRepository.getById(likeUser.getIdUser()));
    }

    @Test
    public void updateUserLike() throws SQLException, IOException {
        likeUserRepository.insert(likeUser);
        LikeUser updateLikeUser = likeUserRepository.getById(likeUser.getIdUser());
        likeUserRepository.update(updateLikeUser);
        assertEquals(updateLikeUser,likeUserRepository.getById(likeUser.getIdUser()));
    }

    @Test
    public void getAllUsers() throws SQLException, IOException {
        List<LikeUser> usersList = likeUserRepository.getAll();
        usersList.forEach(System.out::println);
    }

}
