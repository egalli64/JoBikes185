/**
 * (c) 2019 ACME Inc.
 * JPA repository for Cities
 * 
 * @author Giovaleppe
 */
package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.BikeUser;


@Repository
public interface BikeUserRepository extends CrudRepository<BikeUser, Integer> {
 	List<BikeUser> findAllByOrderById();  	
	List<BikeUser> findAllByOrderByFirstName();
	List<BikeUser> findAllByOrderByLastName();

}
