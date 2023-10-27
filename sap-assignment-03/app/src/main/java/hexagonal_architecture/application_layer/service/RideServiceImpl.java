package hexagonal_architecture.application_layer.service;

import hexagonal_architecture.application_layer.service.exception.*;
import hexagonal_architecture.domain_layer.model.*;
import hexagonal_architecture.domain_layer.service.DataService;
import hexagonal_architecture.domain_layer.service.RideService;
import hexagonal_architecture.infrastructure_layer.out.persistence.EScooterRepositoryAdapter;
import hexagonal_architecture.infrastructure_layer.out.persistence.RideRepositoryAdapter;
import hexagonal_architecture.infrastructure_layer.out.persistence.UserRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RideServiceImpl implements DataService<Ride, String>, RideService {

    @Autowired
    private RideRepositoryAdapter rideRepository;
    @Autowired
    private UserRepositoryAdapter userRepository;
    @Autowired
    private EScooterRepositoryAdapter escooterRepository;

    @Autowired
    private DataService<User, String> userService; //TODO delete
    @Autowired
    private DataService<EScooter, String> escooterService;

    @Override
    public Ride createResource(Ride ride) throws IdAlreadyExistingException, UserNotYetRegisteredException, NotYetRegisteredException {
        Optional<Ride> rideDb = this.rideRepository.findById(ride.getId());
        if (rideDb.isPresent()) {
            throw new IdAlreadyExistingException();
        }
        if (this.userRepository.findById(ride.getUserId()).isEmpty()) {
            throw new UserNotYetRegisteredException();
        }
        if (this.escooterRepository.findById(ride.getEscooterId()).isEmpty()) {
            throw new NotYetRegisteredException();
        }
        EScooter updateEscooter = new EScooter();
        updateEscooter.setId(ride.getEscooterId());
        updateEscooter.setState(EScooter.EScooterState.IN_USE);
        updateEscooter.setLocation(new Location(5.0, 6.0));
        this.escooterService.updateResource(ride.getEscooterId(), updateEscooter);
        return this.rideRepository.save(ride);
    }

    @Override
    public Ride updateResource(String id, Ride ride) {
        if (!ride.getId().equals(id)) {
            throw new ResourceIdMismatchedException();
        }
        Ride rideDb = this.getResourceById(ride.getId());
        rideDb.setUserId(ride.getUserId());
        rideDb.setEscooterId(ride.getEscooterId());
        rideDb.setStartedDate(ride.getStartedDate());
        rideDb.setEndDate(ride.getEndDate().orElse(null));
        rideDb.setOngoing(ride.isOngoing());
        return this.rideRepository.save(rideDb);
    }

    @Override
    public List<Ride> getAllResources() {
        return this.rideRepository.findAll();
    }

    @Override
    public Ride getResourceById(String id) {
        return this.rideRepository.findById(id)
                .orElseThrow(() -> new RideNotFoundException("Record not found with id : " + id));
    }

    @Override
    public void deleteResource(String id) {
        this.rideRepository.delete(this.getResourceById(id));
    }

    @Override
    public Ride endRide(String id) {
        //TODO

        Ride rideDb = this.getResourceById(id);
        rideDb.setEndDate(new Date());
        rideDb.setOngoing(false);

        EScooter escooterDb = this.escooterService.getResourceById(rideDb.getEscooterId());
        escooterDb.setState(EScooter.EScooterState.AVAILABLE);

        this.escooterRepository.save(escooterDb);
        return this.rideRepository.save(rideDb);
    }
}
