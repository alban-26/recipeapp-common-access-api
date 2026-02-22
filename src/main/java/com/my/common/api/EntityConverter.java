package com.my.common.api;


/**
 * Interface for converting between a Domain Model and a Persistence Entity.
 *
 * @param <DOMAIN> the type of the Domain Model
 * @param <ENTITY> the type of the Persistence Entity
 */
public interface EntityConverter<DOMAIN, ENTITY> {

    /**
     * Converts a Persistence Entity to the corresponding Domain Model.
     *
     * @param entity the Persistence Entity to convert
     * @return the Domain Model representing the business logic
     */
    DOMAIN entityToDomain(ENTITY entity);

    /**
     * Converts a Domain Model to the corresponding Persistence Entity.
     *
     * @param domain the Domain Model to convert
     * @return the Persistence Entity representing the database structure
     */
    ENTITY domainToEntity(DOMAIN domain);
}
