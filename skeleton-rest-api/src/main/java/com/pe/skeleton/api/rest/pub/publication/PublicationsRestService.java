package com.pe.skeleton.api.rest.pub.publication;

import com.pe.skeleton.api.dto.ResponseDto;
import com.pe.skeleton.api.dto.publication.PublicationDto;
import com.pe.skeleton.api.dto.publication.PublicationSortOptionDto;
import com.pe.skeleton.api.dto.publication.PublicationsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

/**
 * @author kamen on 2.08.22 г.
 */
@Tag(name = "Publications Filtering", description = "Used to filter publications by anonymous accounts.")
public interface PublicationsRestService {

    @Operation(summary = "Loads publications in pages with the given sort applied.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested page's publications.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationsDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid arguments supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    PublicationsDto getPublications(
            @Parameter(description = "The page index. First page is index 1.", required = true, in = ParameterIn.QUERY) int page,
            @Parameter(description = "The page size, the minimum size is 1.", required = true, in = ParameterIn.QUERY) int size,
            @Parameter(description = "How the publications should be sorted before put in the page.", required = true, in = ParameterIn.QUERY) PublicationSortOptionDto sort
    );

    @Operation(summary = "Loads the provided account's publications in pages with the given sort applied.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested page's publications.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationsDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid arguments supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    PublicationsDto getAccountPublications(
            @Parameter(description = "The account identification", required = true, in = ParameterIn.PATH) UUID accountId,
            @Parameter(description = "The page index. First page is index 1.", required = true, in = ParameterIn.QUERY) int page,
            @Parameter(description = "The page size, the minimum size is 1.", required = true, in = ParameterIn.QUERY) int size,
            @Parameter(description = "How the publications should be sorted before put in the page.", required = true, in = ParameterIn.QUERY) PublicationSortOptionDto sort
    );

    @Operation(summary = "Loads publications by given identifications.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested publications.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationsDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid arguments supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    PublicationsDto loadPublications(
            @Parameter(
                    description = "The publications identifications being checked if they are in any of the account's favorite lists.",
                    required = true,
                    in = ParameterIn.QUERY
            )
            List<UUID> publicationsIds
    );

    @Operation(summary = "Loads the publication associated with the given identification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The page associated with the given identification.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "The provided identification is invalid.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "The publication is not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    PublicationDto load(@Parameter(description = "The publication identification.", required = true, in = ParameterIn.PATH) UUID id);
}
