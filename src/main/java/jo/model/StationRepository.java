/**
 * (c) 2019 ACME Inc.
 * JPA repository for Stations
 */

package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Station;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
    List<Station> findAllByOrderById();
    List<Station> findAllByOrderByName();
}