package com.pe.skeleton.api.rest.pub.accounts;

import com.pe.skeleton.api.dto.ResponseDto;
import com.pe.skeleton.api.dto.account.AccountDto;
import com.pe.skeleton.api.rest.RestUrl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Provides public functionality for accounts data. For example, retrieving public account information such as phone
 * number will be provided by this endpoint.
 *
 * @author kamen on 9/26/2022 г.
 */
@Tag(name = "Accounts", description = "Provides public functionality for accounts data. For example, retrieving public account information such as phone number will be provided by this endpoint.")
@RestController
@RequestMapping(
        value = RestUrl.ACCOUNTS,
        produces = MediaType.APPLICATION_JSON_VALUE,
        headers = "Accept=application/json"
)
public interface AccountsRestService {

    @Operation(summary = "Loads the account's associated data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The account's associated data."),
            @ApiResponse(responseCode = "400", description = "The provided account identification is invalid.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "No account associated with the supplied identification is found.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    @GetMapping("/{accountId:[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}}")
    AccountDto load(
            @PathVariable("accountId")
            @Parameter(description = "The account identification.", required = true, in = ParameterIn.PATH)
            UUID accountId
    );
}
