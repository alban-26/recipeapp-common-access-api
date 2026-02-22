package com.my.common.api;


/**
 * Interface for converting between a Domain Model and a Data Transfer Object (DTO).
 *
 * @param <DOMAIN> the type of the Domain Model
 * @param <DTO> the type of the Data Transfer Object
 */
public interface DtoConverter<DOMAIN, DTO> {

    /**
     * Converts a Data Transfer Object (DTO) to the corresponding Domain Model.
     *
     * @param dto the DTO to convert
     * @return the Domain Model representing the business logic
     */
    DOMAIN dtoToDomain(DTO dto);

    /**
     * Converts a Domain Model to the corresponding Data Transfer Object (DTO).
     *
     * @param domain the Domain Model to convert
     * @return the DTO used for data exchange
     */
    DTO domainToDto(DOMAIN domain);
}
