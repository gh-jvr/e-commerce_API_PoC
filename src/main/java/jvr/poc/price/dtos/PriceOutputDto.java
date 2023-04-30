package jvr.poc.price.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jvr.poc.price.entities.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Output DTO for POST /price service.
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PriceOutputDto extends CommonPriceDto {

    /**
     * Fee attribute.
     */
    @JsonProperty("fee")
    @ApiModelProperty(value = "Fee to apply", dataType = "Long", example = "1")
    private Long fee;

    /**
     * Application initial date attribute.
     */
    @JsonProperty("start_date")
    @ApiModelProperty(value = "Application initial date", dataType = "LocalDateTime", example = "2020-06-14-09.00.00")
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    /**
     * Application final date attribute.
     */
    @JsonProperty("end_date")
    @ApiModelProperty(value = "Application final date", dataType = "LocalDateTime", example = "2020-06-16-21.00.00")
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    /**
     * Product's price attribute.
     */
    @JsonProperty("price")
    @ApiModelProperty(value = "Product's price", dataType = "Double", example = "25,95")
    private Double price;

    /**
     * Custom constructor which initialize an instance taking the Price entity as start point.
     *
     * @param price Price entity instance.
     */
    public PriceOutputDto(Price price) {
        this.fee = price.getPriceId();
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.price = price.getPrice();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
    }
}
