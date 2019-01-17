package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jo.model.OrgRepository;

@Controller
public class OrgCtrl {
	private static final Logger logger = LoggerFactory.getLogger(OrgCtrl.class);

	@Autowired
	OrgRepository repo;

	@GetMapping("/orgs")
	public String allOrgs(Model model) {
		logger.debug("All orgs");
		model.addAttribute("orgs", repo.findAll());
		return "orgs";
	}
}
