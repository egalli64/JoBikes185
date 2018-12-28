package jo.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.entities.Region;

@Controller
public class JBController {
	static final Logger logger = LoggerFactory.getLogger(JBController.class);

	// this is not a good idea!
	@GetMapping("/login")
	public String nakedLogin( //
			@RequestParam(name = "user", defaultValue = "Unknown") String user, //
			@RequestParam(name = "password") String password, //
			Model model) {
		logger.warn("Unsafe login attempt for user: " + user);

		model.addAttribute("user", user);
		return "checkPassword";
	}

	@PostMapping("/login")
	public String login( //
			@RequestParam(name = "user") String user, //
			@RequestParam(name = "password") String password, //
			Model model) {
		logger.debug("Login attempt for user: " + user);

		model.addAttribute("user", user);
		if (user.equals("manager") && password.equals("")) {
			return "manager";
		} else {
			return "checkPassword";
		}
	}

	@GetMapping("/simple")
	public String showCountries(Model model) {
		logger.debug("Show thymeLeaf simple test page");
		model.addAttribute("data", Arrays.asList(new Region(1, "North Europe"), new Region(2, "South Europe")));
		model.addAttribute("user", "Tom Jones");
		return "simple";
	}
}
