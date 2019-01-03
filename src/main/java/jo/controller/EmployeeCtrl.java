package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.EmployeeRepository;
import jo.model.entities.Employee;

@Controller
public class EmployeeCtrl {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeCtrl.class);
	private static final String CODER = "IT_PROG";

	@Autowired
	EmployeeRepository repo;

	@GetMapping("/employees")
	public String allEmployees(Model model) {
		logger.debug("All employees");
		model.addAttribute("employees", repo.findAll());
		return "employees";
	}

	@GetMapping("/coders")
	public String allCoders(Model model) {
		logger.debug("All coders");
		model.addAttribute("employees", repo.findByJobId(CODER));
		return "coders";
	}

	@GetMapping("/coders/create")
	public String createCoder( //
			@RequestParam String first, //
			@RequestParam String last, //
			Model model) {
		logger.debug("Create coder");
		try {
			repo.save(new Employee(first, last));			
		}
		catch(Exception cve) {
			logger.error(String.format("Can't create %s %s", first, last, cve));
		}
		model.addAttribute("employees", repo.findByJobId(CODER));
		return "coders";
	}
}
