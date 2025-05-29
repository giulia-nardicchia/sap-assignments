package hexagonal_architecture.application_layer.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EScooterNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public EScooterNotFoundException(String message) {
        super(message);
    }

    public EScooterNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}