package com.pe.skeleton.events.publication;

import com.pe.skeleton.api.dto.publication.PublicationDto;
import com.pe.skeleton.events.EventDto;

/**
 * Dto which represents Publication Event.
 */
public class PublicationEventDto extends EventDto {

    private PublicationDto publication;

    public PublicationDto getPublication() {
        return publication;
    }

    public void setPublication(PublicationDto publication) {
        this.publication = publication;
    }
}
