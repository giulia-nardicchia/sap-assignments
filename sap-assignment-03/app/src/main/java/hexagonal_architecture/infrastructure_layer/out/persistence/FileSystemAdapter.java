package hexagonal_architecture.infrastructure_layer.out.persistence;

import hexagonal_architecture.domain_layer.model.User;
import hexagonal_architecture.domain_layer.service.UserRepositoryPort;

public class FileSystemAdapter implements UserRepositoryPort {
    @Override
    public void saveUser(User user) {

    }
}
