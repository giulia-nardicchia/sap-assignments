package hexagonal_architecture.infrastructure_layer.out.persistence;

import hexagonal_architecture.domain_layer.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryAdapter extends MongoRepository<User, String> {

}
