/**
 * (c) 2019 ACME Inc.
 * Preference Repository
 * @author SuperCoolMegaFicoJavaTeam(SusiAriaPpe)
 */

package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jo.model.entities.Preference;

public interface PreferenceRepository extends CrudRepository<Preference, String> {
	List<Preference> findAllByOrderByName();
	List<Preference> findAllByOrderBySql();
    List<Preference> findAllByOrderByJava();
    List<Preference> findAllByOrderByHtml();
    List<Preference> findAllByOrderByJavaScript();
}