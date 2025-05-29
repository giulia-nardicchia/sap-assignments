package hexagonal_architecture.domain_layer.service;

public interface RideMonitoringService {
    int countTotalRides();
    int countOngoingRides();
    int countEndedRides();
}