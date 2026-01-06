package com.pe.skeleton.events;

import java.util.List;

/**
 * Represents an event message for a messaging system such as Kafka.
 * This DTO will be serialized in JSON or Avro format before sending to the consumers.
 */
public abstract class EventBatchDto<T> extends EventDto {

    protected List<T> objects;
    /**
     * Specifies old objects for update.
     */
    protected List<T> oldObjects;

    /**
     * Gets the list of new objects.
     *
     * @return list of new objects
     */
    public List<T> getObjects() {
        return objects;
    }

    /**
     * Sets the list of new objects. Nulls are silently removed.
     *
     * @param objects list of new objects
     */
    public void setObjects(final List<T> objects) {
        this.objects = objects;
    }

    /**
     * Gets the list of old objects.
     *
     * @return list of old objects
     */
    public List<T> getOldObjects() {
        return oldObjects;
    }

    /**
     * Sets the list of old objects. Nulls are silently removed.
     *
     * @param oldObjects list of old objects
     */
    public void setOldObjects(final List<T> oldObjects) {
        this.oldObjects = oldObjects;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{"
                + "subject='" + getSubject() + '\''
                + ", action='" + getAction() + '\''
                + ", objects=" + objects
                + ", oldObjects=" + oldObjects
                + '}';
    }
}

