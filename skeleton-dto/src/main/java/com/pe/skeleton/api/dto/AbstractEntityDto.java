package com.pe.skeleton.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 *
 * @author kamen on 06.01.2026
 */
public abstract class AbstractEntityDto extends AbstractDto {

    @Schema(description = "The entity identification.")
    @JsonProperty(value = "id")
    private UUID id;

    @Schema(description = "The exact time when the entity has been created.")
    @JsonProperty(value = "createdAt")
    private ZonedDateTime createdAt;

    @Schema(description = "The exact time when the entity has been updated.")
    @JsonProperty(value = "updatedAt")
    private ZonedDateTime updatedAt;

    public AbstractEntityDto() {
        // POJO
    }

    public AbstractEntityDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
