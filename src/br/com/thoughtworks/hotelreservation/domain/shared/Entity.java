package br.com.thoughtworks.hotelreservation.domain.shared;

public interface Entity {

  /**
   * If entity is now being managed!
   *
   * @return true if the entity is now being managed.
   */
  boolean isManaged();

}