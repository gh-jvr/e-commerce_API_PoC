package jvr.poc.price.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Common DTO class with common input and output parameters.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonPriceDto {

    /**
     * Product's identifier attribute.
     */
    @JsonProperty("product_id")
    @ApiModelProperty(value = "Product's identifier", dataType = "Long", example = "35455")
    protected Long productId;

    /**
     * Product's brand identifier attribute.
     */
    @JsonProperty("brand_id")
    @ApiModelProperty(value = "Product's brand identifier", dataType = "Long", example = "1")
    protected Long brandId;

}
