package jvr.poc.price.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Input DTO for POST /price service.
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PriceInputDto extends CommonPriceDto {

    /**
     * Application date.
     */
    @JsonProperty("application_date")
    @ApiModelProperty(value = "Application date", dataType = "LocalDateTime", example = "2020-06-14-10.00.00")
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime applicationDate;
}
