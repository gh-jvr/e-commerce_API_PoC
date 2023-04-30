package jvr.poc.price.services;

import jvr.poc.price.dtos.PriceInputDto;
import jvr.poc.price.dtos.PriceOutputDto;
import jvr.poc.price.entities.Price;
import jvr.poc.price.exceptions.BusinessLogicException;
import jvr.poc.price.repositories.PriceRepository;
import jvr.poc.price.repositories.criteria.PriceSpecification;
import jvr.poc.price.repositories.criteria.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Price API service Implementation.
 */
@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    /**
     * Repository instance.
     */
    @Autowired
    PriceRepository priceRepository;

    /**
     * Method with all required business logic to process a Post request to /price service.
     *
     * @param inputDto Request input body.
     * @return Service response.
     * @throws BusinessLogicException in case something would go wrong.
     */
    @Override
    public ResponseEntity<List<PriceOutputDto>> postPrice(PriceInputDto inputDto) throws BusinessLogicException {

        List<Price> result = new ArrayList<>();
        List<PriceOutputDto> dtos = new ArrayList<>();

        if (inputDto == null) {
            log.debug("No filter has been indicated for POST /price service call. It is going to obtain all rows from PRICES database table");
            result = priceRepository.findAll();
        } else {
            List<Specification<Price>> specs = new ArrayList<>();
            Specification<Price> spec;

            if (inputDto.getProductId() != null) {
                log.debug("It is going to filter by productId = " + inputDto.getProductId());
                specs.add(new PriceSpecification(new SearchCriteria("productId", "=", inputDto.getProductId())));
            }
            if (inputDto.getBrandId() != null) {
                log.debug("It is going to filter by brandId = " + inputDto.getBrandId());
                specs.add(new PriceSpecification(new SearchCriteria("brandId", "=", inputDto.getBrandId())));
            }
            if (inputDto.getApplicationDate() != null) {
                log.debug("It is going to filter by application date = " + inputDto.getApplicationDate());
                PriceSpecification specApplicationDate = new PriceSpecification(new SearchCriteria("startDate", "<=", inputDto.getApplicationDate()));
                specs.add(specApplicationDate.and(new PriceSpecification(new SearchCriteria("endDate", ">=", inputDto.getApplicationDate()))));
            }

            if (!specs.isEmpty()) {
                spec = specs.remove(0);
                for (Specification<Price> elem : specs) {
                    spec = spec.and(elem);
                }
                log.debug("It is going to obtain rows from PRICES database table.");
                result = priceRepository.findAll(spec);
                log.debug(result.size() + " has been obtained from database.");
            }
        }

        result.forEach(e -> dtos.add(new PriceOutputDto(e)));
        log.info("It is going to return a 200 OK as response from POST /price service");
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
