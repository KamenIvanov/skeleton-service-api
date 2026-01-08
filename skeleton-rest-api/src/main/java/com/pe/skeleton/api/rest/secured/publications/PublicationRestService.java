package com.pe.skeleton.api.rest.secured.publications;

import com.pe.skeleton.api.dto.ResponseDto;
import com.pe.skeleton.api.dto.patch.JsonPatchOperationsDto;
import com.pe.skeleton.api.dto.publication.NewPublicationDto;
import com.pe.skeleton.api.dto.publication.PublicationDto;
import com.pe.skeleton.api.dto.publication.PublicationSortOptionDto;
import com.pe.skeleton.api.dto.publication.PublicationsDto;
import com.pe.skeleton.api.rest.secured.CrudRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

/**
 * @author kamen on 2.08.22 г.
 */
@Tag(name = "Publications", description = "Used for creating, editing, loading and deleting of publications.")
public interface PublicationRestService extends CrudRestService<NewPublicationDto, PublicationDto> {

    @Operation(summary = "Loads account's publications in pages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested page's publications.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid account identification is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class)) }
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class)) }
            )
    })
    PublicationsDto getPublications(
            @Parameter(description = "The requested page index. The first page is 1.", required = true, in = ParameterIn.QUERY) int page,
            @Parameter(description = "An page's size. The minimum is 1 element.", required = true, in = ParameterIn.QUERY) int size,
            @Parameter(description = "How the publications should be sorted before put in the page.", required = true, in = ParameterIn.QUERY) PublicationSortOptionDto sort,
            @Parameter(description = "An account's identification.", required = true, in = ParameterIn.HEADER) UUID requesterId
    );

    @Operation(summary = "Patches account's publication.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The patch is successfully applied to the publication.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid patch data supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class)) }
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class)) }
            )
    })
    void patch(
            @Parameter(description = "The entity identification.", required = true, in = ParameterIn.QUERY) UUID id,
            @Parameter(description = "The patch operations.", required = true, in = ParameterIn.QUERY) JsonPatchOperationsDto patch
    );
}
