package com.pe.skeleton.api.dto.publication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.skeleton.api.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * @author kamen on 2.08.22 г.
 */
@Schema(description = "The publications which are fetched in this page.")
public class PublicationsDto extends PageDto {

    @Schema(description = "The publications for the current page.")
    @JsonProperty(value = "publications")
    private List<PublicationDto> publications;

    public PublicationsDto() {
        super(0, 0L);
    }

    public PublicationsDto(Integer totalPages, Long totalHits, List<PublicationDto> publications) {
        super(totalPages, totalHits);
        this.publications = publications;
    }

    public List<PublicationDto> getPublications() {
        return publications;
    }

    public void setPublications(List<PublicationDto> publications) {
        this.publications = publications;
    }
}
