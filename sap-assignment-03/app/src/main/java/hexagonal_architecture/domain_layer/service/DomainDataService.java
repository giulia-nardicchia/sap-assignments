package hexagonal_architecture.domain_layer.service;

import hexagonal_architecture.application_layer.service.exception.EScooterNotYetRegisteredException;
import hexagonal_architecture.application_layer.service.exception.ResourceIdAlreadyExistingException;
import hexagonal_architecture.application_layer.service.exception.UserNotYetRegisteredException;

import java.util.List;

/**
 * The interface DataService represents a Port in the Hexagonal Architecture.
 * @param <T> represents the type of the data in which the operations can be done.
 * @param <ID> represents the id type.
 */
public interface DomainDataService<T, ID> {

    T createResource(T data) throws ResourceIdAlreadyExistingException, UserNotYetRegisteredException, EScooterNotYetRegisteredException;

    T updateResource(ID id, T data);

    List<T> getAllResources();

    T getResourceById(ID id);

    void deleteResource(ID id);
}
