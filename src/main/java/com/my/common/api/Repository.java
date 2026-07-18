package com.my.common.api;

import com.my.common.api.pagination.PageRequest;
import com.my.common.api.pagination.PageResult;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface defining basic CRUD operations.
 *
 * @param <T>  the entity type
 * @param <ID> the identifier type, extending {@link Identifiable}
 */
public interface Repository<T, ID extends Identifiable> {

    /**
     * Finds an entity by its identifier.
     *
     * @param id the identifier
     * @return an {@link Optional} containing the entity if found, otherwise empty
     */
    Optional<T> findById(ID id);

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    List<T> findAll();

    /**
     * Returns all entities that belong to the specified user.
     *
     * <p>This method is typically used to fetch all domain objects (e.g. recipes)
     * that are owned or created by a given user. The user is identified by their
     * {@link UserId}, which should correspond to the unique user identifier provided
     * by the authentication provider (e.g. the Keycloak <code>sub</code> claim).</p>
     *
     * @param userId the unique identifier of the user whose entities should be retrieved;
     *               must not be {@code null}
     * @return a list of all entities associated with the given user; never {@code null},
     *         but may be empty if the user has no entities
     */
    List<T> findAllByUser(UserId userId);

    PageResult<T> findAllByUser(
            UserId userId,
            PageRequest pageRequest
    );

    /**
     * Saves a new entity.
     *
     * @param t the entity to save
     * @return the saved entity
     */
    T save(T t);

    /**
     * Updates an existing entity.
     *
     * @param t the entity to update
     * @return the updated entity
     */
    T update(T t);

    /**
     * Deletes an entity by its identifier.
     *
     * @param id the identifier of the entity to delete
     */
    void deleteById(ID id);
}
