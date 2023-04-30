package jvr.poc.price.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Custom exception controller.
 */
@ControllerAdvice
public class CustomControllerAdvice {

    /**
     * BusinessLogicException exception type controller.
     * @param e Exception caught.
     * @return Custom response for custom exception.
     */
    @Hidden
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<CustomError> handleBusinessLogicException(BusinessLogicException e) {
        return new ResponseEntity<>(e.getCustomError(), e.getCustomError().getStatus());
    }

    /**
     * General exceptions controller.
     * @param e Exception caught.
     * @return response for the caught exception.
     */
    @Hidden
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleBusinessLogicException(Exception e) {
        String sb = "General error: " + e.getMessage();
        CustomError error = new CustomError(sb, 0);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
