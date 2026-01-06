package com.pe.skeleton.api.dto.publication;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * @author kamen on 1.06.22 г.
 */
@Schema(description = "The publication's available sort options.")
public enum PublicationSortOptionDto implements Serializable {

    NEWEST,
    OLDEST,
    HIGHEST_RATING,
    LOWEST_RATING,
    HIGHEST_PRICE,
    LOWEST_PRICE

}
