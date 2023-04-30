package jvr.poc.price.validators;

import jvr.poc.price.dtos.PriceInputDto;
import jvr.poc.price.exceptions.BusinessLogicException;
import jvr.poc.price.exceptions.CustomError;
import jvr.poc.price.exceptions.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Price service validator class.
 */
@Slf4j
@Component
public class PriceValidator {

    /**
     * POST /price service validator.
     *
     * @param inputDto Request body.
     */
    public void validate(PriceInputDto inputDto) {
        if (inputDto == null) {
            log.error("The request body for the POST service '/price' is null");
            throw new BusinessLogicException(new CustomError(ErrorCodes.ERROR_BODY_NULL.getErrorMessage(), ErrorCodes.ERROR_BODY_NULL.getErrorCode()));
        }
        log.debug("Request body OK. Input parameter applicationDate: [" + inputDto.getApplicationDate() + "], productId: [" + inputDto.getProductId() + "], brandId: [" + inputDto.getBrandId() + "].");
    }
}
