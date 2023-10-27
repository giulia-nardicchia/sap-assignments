package hexagonal_architecture.infrastructure_layer.out.persistence;

import hexagonal_architecture.domain_layer.model.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepositoryAdapter extends MongoRepository<Ride, String> {

}
