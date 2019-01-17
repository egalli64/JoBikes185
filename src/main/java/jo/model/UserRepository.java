package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.User;

	@Repository
	public interface UserRepository extends CrudRepository<User, Integer> {
		List<User> findAllByOrderById();
		List<User> findAllByOrderByUsr();
	 	List<User> findAllByOrderByRol(); 
	}
