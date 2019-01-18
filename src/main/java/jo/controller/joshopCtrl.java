package jo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import jo.model.BikeTypeRepository;



@Controller
public class joshopCtrl {

	private static final Logger logger = LoggerFactory.getLogger(joshopCtrl.class);

	@Autowired
	BikeTypeRepository repo;

	@GetMapping("/joshop")
	public String showTypes(Model model) {
		logger.debug("Get joshop home");
		model.addAttribute("types", repo.findAll());

		return "joshop";
	}


}
