import org.example.entity.UserPhoto;
import org.example.repository.ConnectionFactory;
import org.example.repository.UserPhotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserPhotoTest {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    private final UserPhotoRepository userPhotoRepository
            = new UserPhotoRepository(connectionFactory);

    UserPhoto userPhoto = new UserPhoto(
            null,2L,"adress");

   /* @BeforeEach
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

        userPhotoRepository.insert(userPhoto);
        UserPhoto foundUserPhoto = userPhotoRepository.getByAdress(userPhoto.getAdress());
        assertEquals(userPhoto, foundUserPhoto);
    }

    @Test
    public void removeUserPhoto() throws SQLException, IOException {
        userPhotoRepository.insert(userPhoto);
        UserPhoto foundUserPhoto = userPhotoRepository.getByAdress(userPhoto.getAdress());
        userPhotoRepository.remove(foundUserPhoto);
        assertNull(userPhotoRepository.getByAdress(userPhoto.getAdress()));
    }

    @Test
    public void updateUserPhoto() throws SQLException, IOException {
        userPhotoRepository.insert(userPhoto);
        UserPhoto updateUserPhoto = new UserPhoto(null,3L,"newadress");
        userPhotoRepository.update(updateUserPhoto);
        assertEquals(updateUserPhoto, userPhotoRepository.getByAdress(updateUserPhoto.getAdress()));
    }

    @Test
    public void getAllUserPhoto() throws SQLException, IOException {
        List<UserPhoto> usersList;
        usersList = userPhotoRepository.getAll();
        usersList.stream().forEach(System.out::println);
    }
}
