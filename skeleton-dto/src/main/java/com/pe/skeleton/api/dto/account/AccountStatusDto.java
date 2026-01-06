package com.pe.skeleton.api.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author kamen on 3/2/2024 г.
 */
@Schema(description = "The available statuses.")
public enum AccountStatusDto {

    @Schema(description = "The account has been created, not yet activated via the email activation link")
    CREATED,
    @Schema(description = "The account has been activated via the email activation link")
    ACTIVE,
    @Schema(description = "The account has been marked for deletion")
    MARKED_FOR_DELETION,
    @Schema(description = "The account has been banned for usage")
    BANNED
}
