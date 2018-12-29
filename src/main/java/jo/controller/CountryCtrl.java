package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.CountryRepository;

@Controller
public class CountryCtrl {
	static final Logger logger = LoggerFactory.getLogger(CountryCtrl.class);

	@Autowired
	CountryRepository repo;

	@GetMapping("/countries")
	public String allCountries(Model model) {
		logger.debug("All countries");
		model.addAttribute("countries", repo.findAll());
		return "countries";
	}

	@GetMapping("/countriesByRegion")
	public String countriesByRegion( //
			@RequestParam Integer id, //
			@RequestParam String name, //
			Model model) {
		logger.debug(String.format("Countries by region %d (%s)", id, name));

		model.addAttribute("countries", repo.findByRegId(id));
		model.addAttribute("region", name);
		return "countriesByRegion";
	}
}
