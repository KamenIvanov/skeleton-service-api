package com.pe.skeleton.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

/**
 * @author kamen on 1.06.22 г.
 */
public abstract class AbstractNamedEntityDto extends AbstractEntityDto {

    @Schema(description = "The entity name.")
    @JsonProperty(value = "name")
    private String name;

    protected AbstractNamedEntityDto() {
        // POJO
    }

    protected AbstractNamedEntityDto(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
