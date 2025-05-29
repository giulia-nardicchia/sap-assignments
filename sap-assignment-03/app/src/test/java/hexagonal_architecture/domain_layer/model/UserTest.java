package hexagonal_architecture.domain_layer.model;

import hexagonal_architecture.application_layer.service.UserServiceImpl;
import hexagonal_architecture.application_layer.service.exception.ResourceIdAlreadyExistingException;
import hexagonal_architecture.infrastructure_layer.out.persistence.UserRepositoryAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = { UserTest.class })
class UserTest {

    @Mock
    private UserRepositoryAdapter userMockRepository;
    @InjectMocks
    private UserServiceImpl userDataService;

    private final List<User> users = new ArrayList<>();
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        this.user1 = new User("gnardicchia", "Giulia", "Nardicchia");
        this.user2 = new User("rgennari", "Riccardo", "Gennari");
        users.add(user1);
        users.add(user2);
    }

    @Test
    public void getAllUserTest() {
        Mockito.when(userMockRepository.findAll()).thenReturn(users);
        Assertions.assertEquals(2, userDataService.getAllResources().size());
    }

    @Test
    public void getUserByIdTest() {
        String userId = "gnardicchia";
        Mockito.when(userMockRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
        Assertions.assertEquals(user1, userDataService.getResourceById(userId));
    }

    @Test
    public void createUserTest() {
        String userId = "snardicchia";
        User user3 = new User(userId, "Sara", "Nardicchia");
        Mockito.when(userMockRepository.findById(user3.getId())).thenReturn(Optional.of(user3));
        Assertions.assertEquals(user3, userDataService.getResourceById(userId));
    }

    @Test
    public void createUserExceptionTest() {
        Mockito.when(userMockRepository.findById(user2.getId())).thenReturn(Optional.of(user2));
        Assertions.assertThrows(ResourceIdAlreadyExistingException.class, () -> { userDataService.createResource(user2); });
    }
}