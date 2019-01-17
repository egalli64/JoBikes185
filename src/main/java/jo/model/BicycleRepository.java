package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Bicycle;

@Repository
public interface BicycleRepository extends CrudRepository<Bicycle, Integer> {
 	List<Bicycle> findAllByOrderById();
 	List<Bicycle> findAllByOrderByTarget(); 
 	List<Bicycle> findAllByOrderByTypeId(); 
 	List<Bicycle> findAllByOrderByPrice(); 
 	List<Bicycle> findAllByOrderByBrand();
}