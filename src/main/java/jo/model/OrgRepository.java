package jo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jo.model.entities.Org;

@Repository
public interface OrgRepository extends CrudRepository<Org, Integer> {
}
