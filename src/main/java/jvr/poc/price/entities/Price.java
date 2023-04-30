package jvr.poc.price.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Price entity. It represents the Prices DB table.
 */
@Getter
@Setter
@Table(name = "PRICES")
@Entity
public class Price {

    @ApiModelProperty(notes = "Price ID", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID")
    private Long priceId;

    @ApiModelProperty(notes = "Brand ID", example = "1", required = true)
    @Column(name = "BRAND_ID")
    private Long brandId;

    @ApiModelProperty(notes = "Product ID", example = "35455", required = true)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @ApiModelProperty(notes = "Priority", example = "0", required = true)
    @Column(name = "PRIORITY")
    private boolean priority;

    @ApiModelProperty(notes = "Price", example = "24,99", required = true)
    @Column(name = "PRICE")
    private Double price;

    @ApiModelProperty(notes = "Currency code", example = "EUR", required = true)
    @Column(name = "CURR")
    private String currency;

    @ApiModelProperty(notes = "Application start date", example = "2020-06-14-10.00.00", required = true)
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "Application end date", example = "2020-06-16-21.00.00", required = true)
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
}
