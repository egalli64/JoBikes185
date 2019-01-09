/**
 * (c) 2019 ACME Inc.
 * JPA repository for Stations
 */

package jo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Station;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
}