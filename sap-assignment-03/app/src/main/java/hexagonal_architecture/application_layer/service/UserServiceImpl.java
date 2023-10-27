package hexagonal_architecture.application_layer.service;

import hexagonal_architecture.application_layer.service.exception.ResourceIdMismatchedException;
import hexagonal_architecture.domain_layer.model.User;
import hexagonal_architecture.domain_layer.service.DataService;
import hexagonal_architecture.application_layer.service.exception.IdAlreadyExistingException;
import hexagonal_architecture.infrastructure_layer.out.persistence.UserRepositoryAdapter;
import hexagonal_architecture.application_layer.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * UserServiceImpl implementation of UserService, represents an Adapter on the Hexagonal Architecture.
 */
@Service
@Transactional
public class UserServiceImpl implements DataService<User, String> {

    @Autowired
    private UserRepositoryAdapter userRepository;
    @Override
    public User createResource(User user) throws IdAlreadyExistingException {
        Optional<User> userDb = this.userRepository.findById(user.getId());
        if (userDb.isPresent()) {
            throw new IdAlreadyExistingException();
        }
        return this.userRepository.save(user);
    }

    @Override
    public User updateResource(String id, User user) {
        if (!user.getId().equals(id)) {
            throw new ResourceIdMismatchedException();
        }
        User userDb = this.getResourceById(user.getId());
        userDb.setName(user.getName());
        userDb.setSurname(user.getSurname());
        return this.userRepository.save(userDb);
    }

    @Override
    public List<User> getAllResources() {
        return this.userRepository.findAll();
    }

    @Override
    public User getResourceById(String id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Record not found with id : " + id));
    }

    @Override
    public void deleteResource(String id) {
        this.userRepository.delete(this.getResourceById(id));
    }
}
