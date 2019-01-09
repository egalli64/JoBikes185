/**
 * (c) 2019 ACME Inc.
 * Controller for Stations
 * @author Ariam
 */
package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jo.model.StationRepository;

@Controller
public class StationCtrl {
	private static final Logger logger = LoggerFactory.getLogger(StationCtrl.class);

	@Autowired
	private StationRepository repo;

	@GetMapping("/stations")
	public String showStations(Model model) {
		logger.debug("Get all stations");
		model.addAttribute("stations", repo.findAll());
		return "stations";
    }
}
