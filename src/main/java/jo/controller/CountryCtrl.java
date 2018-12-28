package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jo.model.CountryRepository;

@Controller
public class CountryCtrl {
	static final Logger logger = LoggerFactory.getLogger(CountryCtrl.class);

	@Autowired
	CountryRepository repo;

	@GetMapping("/countries")
	public String showCountries(Model model) {
		logger.debug("Show countries");
		model.addAttribute("countries", repo.findAll());
		return "countries";
	}
}
