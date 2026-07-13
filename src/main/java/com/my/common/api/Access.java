package com.my.common.api;

import java.util.List;
import java.util.Optional;

/**
 * Generic access interface for basic CRUD operations.
 *
 * @param <T>  the entity type
 * @param <ID> the type of the entity identifier
 */
public interface Access<T, ID> {

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id the identifier
     * @return an {@link Optional} containing the entity if found, otherwise empty
     */
    Optional<T> getById(ID id);

    /**
     * Returns all entities.
     *
     * @return a list of all entities
     */
    List<T> getAll();


    /**
     * Returns all entities that belong to the specified user.
     *
     * <p>This method is typically used to fetch all domain objects (e.g. recipes)
     * that are owned or created by a given user. The user is identified by their
     * {@link UserId}, which should correspond to the unique user identifier provided
     * by the authentication provider (e.g. the Keycloak <code>sub</code> claim).</p>
     *
     * @param userId the unique identifier of the user whose entities should be retrieved;
     *               must not be null.
     * @return a list of all entities associated with the given user; never null,
     *         but may be empty if the user has no entities
     */
    List<T> getAllByUser(UserId userId);

    /**
     * Returns a paginated list of entities that belong to the specified user.
     *
     * <p>This method is intended for endpoints that support pagination. The
     * returned {@link PageResult} contains both the requested page of entities
     * and the associated pagination metadata (e.g. total number of elements).</p>
     *
     * @param userId the unique identifier of the user whose entities should be
     *               retrieved; must not be {@code null}.
     * @param pageRequest the pagination settings defining which page should be
     *                    returned and how many entities it should contain; must
     *                    not be {@code null}.
     * @return a {@link PageResult} containing the requested page of entities and
     *         the corresponding pagination metadata; never {@code null}.
     */
    PageResult<T> getAllByUser(UserId userId, PageRequest pageRequest);

    /**
     * Saves the given entity.
     *
     * @param item the entity to save
     * @return the saved entity
     */
    T save(T item);

    /**
     * Deletes the given entity.
     *
     * @param item the entity to delete
     */
    void delete(T item);
}
