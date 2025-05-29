package hexagonal_architecture.application_layer.service;

import hexagonal_architecture.domain_layer.model.Ride;
import hexagonal_architecture.domain_layer.service.DomainDataService;
import hexagonal_architecture.domain_layer.service.RideMonitoringService;
import org.springframework.stereotype.Service;

@Service
public class RideMonitoringServiceImpl implements RideMonitoringService {

    private final DomainDataService<Ride, String> rideDataService;

    public RideMonitoringServiceImpl(DomainDataService<Ride, String> rideDataService) {
        this.rideDataService = rideDataService;
    }

    @Override
    public int countOngoingRides() {
        return (int) rideDataService.getAllResources().stream()
                .filter(Ride::isOngoing)
                .count();
    }

    @Override
    public int countEndedRides() {
        return (int) rideDataService.getAllResources().stream()
                .filter(ride -> !ride.isOngoing())
                .count();
    }

    @Override
    public int countTotalRides() {
        return rideDataService.getAllResources().size();
    }
}
