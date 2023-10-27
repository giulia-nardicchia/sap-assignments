package hexagonal_architecture.application_layer.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceIdMismatchedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ResourceIdMismatchedException() {

    }
}