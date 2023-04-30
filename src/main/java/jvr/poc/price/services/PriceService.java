package jvr.poc.price.services;

import jvr.poc.price.dtos.PriceInputDto;
import jvr.poc.price.dtos.PriceOutputDto;
import jvr.poc.price.exceptions.BusinessLogicException;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Service interface which defines all API method for Price.
 */
public interface PriceService {

    /**
     * '/price' Post method definition.
     * @param inputDto Input request body.
     * @return Response of the required service.
     * @throws BusinessLogicException if something would go wrong.
     */
    ResponseEntity<List<PriceOutputDto>> postPrice(PriceInputDto inputDto) throws BusinessLogicException;
}
