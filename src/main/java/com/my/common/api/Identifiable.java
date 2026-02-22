package com.my.common.api;

/**
 * Represents an entity with a unique identifier.
 */
public interface Identifiable {

    /**
     * Returns the unique identifier of the entity.
     *
     * @return the entity ID
     */
    long id();
}