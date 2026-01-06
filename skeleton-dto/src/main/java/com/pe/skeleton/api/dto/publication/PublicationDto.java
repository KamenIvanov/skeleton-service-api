package com.pe.skeleton.api.dto.publication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.skeleton.api.dto.AbstractEntityDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author kamen on 2.08.22 г.
 */
@Schema(description = "The publication's data.")
public class PublicationDto extends AbstractEntityDto {

    @Schema(description = "The publication's creator identification.")
    @JsonProperty(value = "accountId")
    private UUID accountId;
    @Schema(description = "The publication's description.")
    @JsonProperty(value = "description")
    private String description;
    @Schema(description = "The publication's price.")
    @JsonProperty(value = "price")
    private Double price;

    @Schema(description = "The publication's expiring date.")
    @JsonProperty(value = "expiresAt")
    private ZonedDateTime expiresAt;
    @Schema(description = "Is the automatic renewal enabled for this publication.")
    @JsonProperty(value = "autoRenewal")
    private Boolean autoRenewal;

    public PublicationDto() {
        // POJO
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
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

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(Boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }
}
