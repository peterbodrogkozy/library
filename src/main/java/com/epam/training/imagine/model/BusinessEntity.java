package com.epam.training.imagine.model;

/**
 * This interface denotes a business entity.
 *
 * @param <ID> the type used as an identifier of this entity
 */
public interface BusinessEntity<ID> {

    /** Function which returns the unique identifier of the entity.
     *
     * @return the unique identifier value of the entity.
     */
    ID getId();
}
