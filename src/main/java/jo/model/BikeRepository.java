/**
 * (c) 2019 ACME Inc.
 * JPA repository for Bikes
 * 
 * @author Federico
 */
package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Bike;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Integer> {
 	List<Bike> findAllByOrderById();
 	List<Bike> findAllByOrderByCityId(); 
 	List<Bike> findAllByOrderByType(); 
}
