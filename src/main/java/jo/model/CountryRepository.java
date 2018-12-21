package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
	@Override
	List<Country> findAll();

	List<Country> findByName(String name);
	List<Country> findByRegId(Integer regId);
}
