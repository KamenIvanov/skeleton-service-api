package com.pe.skeleton.events;

import com.pe.skeleton.api.dto.AbstractDto;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Represents an event message for a messaging system such as Kafka.
 * This DTO will be serialized in JSON or Avro format before sending to the consumers.
 */
public abstract class EventDto extends AbstractDto {

    private String accountId;
    private String subject;
    private String action;
    private String performer;

    private UUID          version;
    private ZonedDateTime timestamp;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public EventDto withUpdatedAt(final ZonedDateTime updatedAt) {
        return this;
    }

    public UUID getVersion() {
        return version;
    }

    public void setVersion(UUID version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "action='" + action + '\'' +
                ", performer='" + performer + '\'' +
                ", subject='" + subject + '\'' +
                ", tenantId='" + accountId + '\'' +
                ", timestamp=" + timestamp +
                ", version=" + version +
                '}';
    }
}

