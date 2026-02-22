package com.my.common.api;


/**
 * Interface for converting between a Domain Model and an Event.
 *
 * @param <DOMAIN> the type of the Domain Model
 * @param <EVENT> the type of the Event
 */
public interface EventConverter<DOMAIN, EVENT> {

    /**
     * Converts an Event to the corresponding Domain Model.
     *
     * @param event the Event to convert
     * @return the Domain Model constructed from the Event
     */
    DOMAIN eventToDomain(EVENT event);

    /**
     * Converts a Domain Model to the corresponding Event.
     *
     * @param domain the Domain Model to convert
     * @return the Event representing the Domain Model
     */
    EVENT domainToEvent(DOMAIN domain);
}
