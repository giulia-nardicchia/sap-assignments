package hexagonal_architecture.application_layer.web;

import hexagonal_architecture.domain_layer.model.Ride;
import hexagonal_architecture.domain_layer.service.DomainDataService;
import hexagonal_architecture.application_layer.service.exception.EScooterNotYetRegisteredException;
import hexagonal_architecture.application_layer.service.exception.ResourceIdAlreadyExistingException;
import hexagonal_architecture.application_layer.service.exception.UserNotYetRegisteredException;
import hexagonal_architecture.domain_layer.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RideAPI {

    @Autowired
    private DomainDataService<Ride, String> rideService;

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getAllRide() {
        return ResponseEntity.ok().body(this.rideService.getAllResources());
    }

    @GetMapping("/rides/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.rideService.getResourceById(id));
    }

    @PostMapping("/rides")
    public ResponseEntity<Ride> createRide(Ride ride) throws ResourceIdAlreadyExistingException, UserNotYetRegisteredException, EScooterNotYetRegisteredException {
        return ResponseEntity.ok().body(this.rideService.createResource(ride));
    }

    @PutMapping("/rides/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable String id, @RequestBody Ride ride) {
        ride.setId(id); // TODO delete
        return ResponseEntity.ok().body(this.rideService.updateResource(id, ride));
    }

    @DeleteMapping("/rides/{id}")
    public HttpStatus deleteRide(@PathVariable String id) {
        this.rideService.deleteResource(id);
        return HttpStatus.OK;
    }

    @GetMapping("/rides/end")
    public ResponseEntity<Ride> endRide(@RequestParam String id) {
        return ResponseEntity.ok().body(((RideService) this.rideService).endRide(id));
    }
}
