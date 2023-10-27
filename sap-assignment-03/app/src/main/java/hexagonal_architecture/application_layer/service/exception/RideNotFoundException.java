package hexagonal_architecture.application_layer.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RideNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RideNotFoundException(String message) {
        super(message);
    }

    public RideNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}