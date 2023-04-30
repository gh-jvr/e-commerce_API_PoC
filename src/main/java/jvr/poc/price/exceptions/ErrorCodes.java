package jvr.poc.price.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Error codes enum.
 */
@AllArgsConstructor
@Getter
public enum ErrorCodes {

    ERROR_BODY_NULL("The request body cannot be null. Please, insert a valid request body", 100);

    /**
     * Error description message.
     */
    private final String errorMessage;

    /**
     * Internal error code.
     */
    private final int errorCode;

}
