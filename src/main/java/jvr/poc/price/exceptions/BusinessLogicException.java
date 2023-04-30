package jvr.poc.price.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom API exception for business logic.
 */
@AllArgsConstructor
@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessLogicException extends RuntimeException {

    /**
     * Custom error generated.
     */
    private final CustomError customError;

}
