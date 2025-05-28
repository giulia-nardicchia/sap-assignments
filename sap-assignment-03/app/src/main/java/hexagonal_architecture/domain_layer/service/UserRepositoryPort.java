package hexagonal_architecture.domain_layer.service;

import hexagonal_architecture.domain_layer.model.User;

public interface UserRepositoryPort {
    void saveUser(User user);
}
