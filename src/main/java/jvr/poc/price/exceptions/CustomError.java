package jvr.poc.price.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Bean to define custom API error.
 */
@Getter
@Setter
public class CustomError {

    /**
     * Timestamp of the error.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    /**
     * HTTP status code.
     */
    private HttpStatus status;

    /**
     * Error message description.
     */
    private String message;

    /**
     * Internal error code.
     */
    private int errorCode;

    /**
     * Default constructor.
     */
    public CustomError(){
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST;
        this.message = "General error";
        this.errorCode = 1;
    }

    /**
     * Custom constructor.
     * @param message Error description to show.
     * @param errorCode Internal error code.
     */
    public CustomError(String message, int errorCode) {
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.errorCode = errorCode;
    }
}
