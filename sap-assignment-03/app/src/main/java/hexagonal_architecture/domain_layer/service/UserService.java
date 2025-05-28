package hexagonal_architecture.domain_layer.service;

import hexagonal_architecture.domain_layer.model.User;

import java.util.List;

// TODO delete
public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    void deleteUser(long id);
}
