package hexagonal_architecture.domain_layer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

/**
 * Domain model of the EScooter entity.
 */
@Document(collection = "escooter")
public class EScooter {

    @Id
    private String id;
    private EScooterState state;
    private Location location;
    public enum EScooterState { AVAILABLE, IN_USE, MAINTENANCE }

    public EScooter() {
        this.state = EScooterState.AVAILABLE;
        this.location = null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EScooterState getState() {
        return this.state;
    }

    public void setState(EScooterState state) {
        this.state = state;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(this.location);
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
