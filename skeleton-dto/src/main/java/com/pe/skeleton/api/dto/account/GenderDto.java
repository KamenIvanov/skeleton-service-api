package com.pe.skeleton.api.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * @author kamen on 6/4/2022 г.
 */
@Schema(description = "The available genders.")
public enum GenderDto implements Serializable {
    MALE,
    FEMALE,
    NOT_TO_SAY
}
