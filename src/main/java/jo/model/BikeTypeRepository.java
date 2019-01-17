package jo.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.BikeType;

@Repository
public interface BikeTypeRepository extends CrudRepository<BikeType, Integer> {
	List<BikeType> findAll();

	List<BikeType> findAllById();

	List<BikeType> findAllByOrderById();

	List<BikeType> findAllByOrderByTypes();
}
