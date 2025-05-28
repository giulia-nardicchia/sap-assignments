package hexagonal_architecture.application_layer.service;

import hexagonal_architecture.application_layer.service.exception.ResourceIdMismatchedException;
import hexagonal_architecture.domain_layer.model.EScooter;
import hexagonal_architecture.domain_layer.service.DataService;
import hexagonal_architecture.application_layer.service.exception.EScooterNotFoundException;
import hexagonal_architecture.application_layer.service.exception.IdAlreadyExistingException;
import hexagonal_architecture.infrastructure_layer.out.persistence.EScooterRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class EScooterServiceImpl implements DataService<EScooter, String> {

    @Autowired
    private EScooterRepositoryAdapter escooterRepository;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public EScooter createResource(EScooter escooter) throws IdAlreadyExistingException {
        Optional<EScooter> escooterDb = this.escooterRepository.findById(escooter.getId());
        if (escooterDb.isPresent()) {
            throw new IdAlreadyExistingException();
        }
        return this.escooterRepository.save(escooter);
    }

    @Override
    public EScooter updateResource(String id, EScooter escooter) {
        if (!escooter.getId().equals(id)) {
            throw new ResourceIdMismatchedException();
        }
        EScooter escooterDb = this.getResourceById(id);

        escooterDb.setState(escooter.getState());
        escooterDb.setLocation(escooter.getLocation().orElse(null));

        this.logger.log(Level.INFO, "Escooter New \n" +
                "\nid: " + escooter.getId() +
                "\nstate: " + escooter.getState() +
                "\nlocation: " + escooter.getLocation().orElse(null));

        return this.escooterRepository.save(escooterDb);
    }

    @Override
    public List<EScooter> getAllResources() {
        return this.escooterRepository.findAll();
    }

    @Override
    public EScooter getResourceById(String id) {
        return this.escooterRepository.findById(id)
                .orElseThrow(() -> new EScooterNotFoundException("Record not found with id : " + id));
    }

    @Override
    public void deleteResource(String id) {
        this.escooterRepository.delete(this.getResourceById(id));
    }
}
