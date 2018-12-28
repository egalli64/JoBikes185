package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.RegionRepository;
import jo.model.entities.Region;

@Controller
public class RegionCtrl {
	static final Logger logger = LoggerFactory.getLogger(RegionCtrl.class);

	@Autowired
	RegionRepository repo;

	@GetMapping("/regions")
	public String showRegions(Model model) {
		logger.debug("Show regions");
		model.addAttribute("regions", repo.findAll());
		return "regions";
	}

	@GetMapping("/region/save")
	public String saveRegion( //
			@RequestParam(name = "id") int id, //
			@RequestParam(name = "name") String name, //
			Model model) {
		logger.debug(String.format("Save region %d, %s", id, name));
		repo.save(new Region(id, name));

		model.addAttribute("regions", repo.findAll());
		return "regions";
	}
}
