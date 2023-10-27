package hexagonal_architecture.domain_layer.service;

import hexagonal_architecture.domain_layer.model.Ride;

public interface RideService {
    Ride endRide(String id);
}
