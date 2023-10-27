package hexagonal_architecture.infrastructure_layer.out.persistence;

import hexagonal_architecture.domain_layer.model.EScooter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EScooterRepositoryAdapter extends MongoRepository<EScooter, String> {

}
