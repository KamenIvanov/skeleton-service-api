package com.pe.skeleton.api.dto.publication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.skeleton.api.dto.AbstractDto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author kamen on 2.08.22 г.
 */
@Schema(description = "Used to create a new publication.")
public class NewPublicationDto extends AbstractDto {

    @Schema(description = "The publication's description.")
    @JsonProperty(value = "description")
    private String  description;
    @Schema(description = "The publication's price.")
    @JsonProperty(value = "price")
    private Double  price;
    @Schema(description = "Is the automatic renewal enabled for this publication.")
    @JsonProperty(value = "autoRenewal")
    private Boolean autoRenewal;

    public NewPublicationDto() {
        // POJO
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(Boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }
}
