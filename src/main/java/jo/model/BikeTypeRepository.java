package jo.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.BikeType;

@Repository
public interface BikeTypeRepository extends CrudRepository<BikeType, Integer> {
	List<BikeType> findAll();

	List<BikeType> findAllById(int id);

	List<BikeType> findAllByOrderById();

	List<BikeType> findAllByOrderByType();
}
