/**
 * (c) 2019 ACME Inc.
 * Controller for Preferences
 * @author SuperCoolMegaFicoJavaTeam(SusiAriaPpe)
 *
 */
package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jo.model.PreferenceRepository;
import jo.model.entities.Preference;


@Controller
public class PreferenceCtrl {
	private static final Logger logger = LoggerFactory.getLogger(PreferenceCtrl.class);

	@Autowired
	private PreferenceRepository repo;

	@GetMapping("/preferences")
	public String showPreferences(Model model) {
		logger.debug("Get all preferences");
		model.addAttribute("preferences", repo.findAll());
		return "preferences";
	}

	@GetMapping("/preferences/save")
	public String savePreference( //
			@RequestParam(name = "name") String name, //
			@RequestParam(name = "sql") Integer sql, //
			@RequestParam(name = "java") Integer java, //
			@RequestParam(name = "html") Integer html, //
			Model model) {
		Preference preference = new Preference(name, sql,java,html);
		logger.debug("Save Preference " + preference);
		repo.save(preference);

		model.addAttribute("preferences", repo.findAll());
		return "preferences";
	}

	@GetMapping("/preferences/delete")
	public String deletePreference( //
			@RequestParam String name, //
			Model model) {
		logger.debug("Delete worker  " + name);
		repo.deleteById(name);

		model.addAttribute("preference", repo.findAll());
		return "preferences";
	}

}
