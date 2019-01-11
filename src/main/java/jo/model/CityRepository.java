/**
 * (c) 2019 ACME Inc.
 * JPA repository for Cities
 * 
 * @author Ariam
 */
package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.City;
import jo.model.entities.Employee;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
 	List<City> findAllByOrderById();  	
	List<City> findAllByOrderByName();


}
