package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, String> {
	@Override
	List<Region> findAll();
}
