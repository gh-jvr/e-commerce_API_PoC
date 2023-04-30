package jvr.poc.price.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jvr.poc.price.dtos.PriceInputDto;
import jvr.poc.price.dtos.PriceOutputDto;
import jvr.poc.price.services.PriceService;
import jvr.poc.price.validators.PriceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Main API controller. This is in charge of manage incoming request.
 */
@Slf4j
@Api(tags = {"Price operations"}, produces = MediaType.APPLICATION_JSON_VALUE, value = "List of operations related with the product prices")
@RestController
public class PriceController {

    /**
     * Price service instance.
     */
    @Autowired
    private PriceService priceService;

    /**
     * Price request body validator.
     */
    @Autowired
    private PriceValidator priceValidator;

    /**
     * Controller for the endpoint POST /price.
     *
     * @param body Input request body.
     * @return Service response for /Price.
     */
    @PostMapping("/price")
    @ApiOperation("Obtain prices information about a product.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful request", response = PriceOutputDto.class),
            @ApiResponse(code = 400, message = "Business logic error")})
    public ResponseEntity<List<PriceOutputDto>> getPrice(@RequestBody(required = false) PriceInputDto body) {
        priceValidator.validate(body);
        log.info("A request to POST /price service has been received");
        return priceService.postPrice(body);
    }

}
