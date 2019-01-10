/**
 * (c) 2019 ACME Inc.
 * Preference Repository
 * @author SuperCoolMegaFicoJavaTeam(SusiAriaPpe)
 */

package jo.model;

import org.springframework.data.repository.CrudRepository;
import jo.model.entities.Preference;

public interface PreferenceRepository extends CrudRepository<Preference, String> {

}