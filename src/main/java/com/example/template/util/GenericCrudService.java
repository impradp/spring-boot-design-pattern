package com.example.template.util;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.lang.NonNull;

public interface GenericCrudService<T> {

  /**
   * Fetches list of all entities
   *
   * @return The list of entities of particular type in the system
   */
  List<T> findAll();

  /**
   * Saves entities data
   *
   * @param entity The entity object to be saved in the system
   * @return The saved entity
   */
  T save(@NonNull @Valid T entity);

  /**
   * Fetches entity by id
   *
   * @param id The unique identifier of the entity created
   * @return The entity object matching its id
   */
  T findById(long id);

  /**
   * Updates the entity
   *
   * @param entity The entity object containing updated values
   */
  String update(@NonNull @Valid T entity);

  /**
   * Delete the entity by id.
   *
   * @param id Identifier for entity.
   * @return String as message.
   */
  String deleteById(@Valid long id);

}
