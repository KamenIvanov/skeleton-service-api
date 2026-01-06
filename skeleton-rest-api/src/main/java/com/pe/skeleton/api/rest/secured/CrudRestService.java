package com.pe.skeleton.api.rest.secured;

import com.pe.skeleton.api.dto.AbstractDto;
import com.pe.skeleton.api.dto.AbstractEntityDto;
import com.pe.skeleton.api.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.pe.skeleton.api.rest.HeaderConstants.REQUESTER_ID;

/**
 * @author kamen on 2.08.22 г.
 */
public interface CrudRestService<NewEntityVo extends AbstractDto, EntityVo extends AbstractEntityDto> {

    /**
     * Creates a new entity. If the entity already exists, conflict (409) is returned.
     *
     * @param entityVo    the entity being created, if the entity is not a valid one, a bad request (400) is returned
     * @param requesterId the requester id, when creating the entity, if there's no requester, Unauthorized (401) is returned
     * @return the newly created entity
     */
    @Operation(summary = "Creates a new entity.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The newly created entity.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "409", description = "Entity with the same identification already exists.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            )
    })
    @PostMapping
    EntityVo create(
            @Parameter(description = "Entity's data.", required = true, in = ParameterIn.HEADER)
            @RequestBody
            NewEntityVo entityVo,
            @Parameter(description = "An account's identification.", required = true, in = ParameterIn.HEADER)
            @RequestHeader(REQUESTER_ID)
            UUID requesterId
    );

    /**
     * Updates an existing entity, if the entity doesn't exist, not found (404) is returned.
     *
     * @param entityVo the entity being updated, if the entity is not a valid one, a bad request is returned
     * @param requesterId   the requester id, when updating the entity if the requester is not its owner, Unauthorized response is returned
     * @return the updated entity
     */
    @Operation(summary = "Updates an existent entity's data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The updated entity.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Entity with the supplied identification not found.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            )
    })
    @PutMapping
    EntityVo update(
            @Parameter(description = "Entity's data.", required = true, in = ParameterIn.HEADER)
            @RequestBody
            EntityVo entityVo,
            @Parameter(description = "An account's identification.", required = true, in = ParameterIn.HEADER)
            @RequestHeader(REQUESTER_ID)
            UUID requesterId
    );

    /**
     * Loads an entity by the provided entityId. If the entity is not found, a not found (404) is returned.
     *
     * @param id          the entity id
     * @param requesterId the requester id
     * @return the entity or 404 if it's not found
     */
    @Operation(summary = "Loads the requested entity associated with the supplied identification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The entity associated with the supplied identification.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Entity with the supplied identification not found.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            )
    })
    @GetMapping("/{id}")
    EntityVo loadById(
            @Parameter(description = "The requested entity's identification.", required = true, in = ParameterIn.HEADER)
            @PathVariable("id") UUID id,
            @Parameter(description = "An account's identification.", required = true, in = ParameterIn.HEADER)
            @RequestHeader(REQUESTER_ID)
            UUID requesterId
    );

    /**
     * Deletes the entity associated with the provided <code>entityId</code>. If the entity is not found, OK (200) is returned.
     *
     * @param id          the entity's id
     * @param requesterId the requester id
     */
    @Operation(summary = "Deletes the entity associated with the supplied identification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The entity associated with the supplied identification is deleted.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Entity with the supplied identification not found.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            )
    })
    @DeleteMapping("/{id}")
    void delete(
            @Parameter(description = "The entity's identification being deleted.", required = true, in = ParameterIn.HEADER)
            @PathVariable("id")
            UUID id,
            @Parameter(description = "An account's identification.", required = true, in = ParameterIn.HEADER)
            @RequestHeader(REQUESTER_ID)
            UUID requesterId
    );
}
