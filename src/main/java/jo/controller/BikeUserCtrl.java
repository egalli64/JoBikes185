/**
 * (c) 2019 ACME Inc.
 * Controller for Cities
 * 
 * 	@author GiovAlePpe
 */
package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.BikeUserRepository;
import jo.model.entities.BikeUser;


@Controller
public class BikeUserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(BikeUserCtrl.class);

	@Autowired
	BikeUserRepository repo;

	

	@GetMapping("/bikeusers")
	public String showBikeUserOrderedbyId(Model model) {
		logger.debug("Get all bikeusers");
		model.addAttribute("bikeusers", repo.findAllByOrderById());
		return "bikeusers";
	}
	
	@GetMapping("/bikeusers/orderbylastname")
	public String showBikeUserOrderedbyLastName(Model model) {
		logger.debug("Get all bikeusers");
		model.addAttribute("bikeusers", repo.findAllByOrderByLastName());
		return "bikeusers";
	}
	
	@GetMapping("/bikeusers/orderbyfirstname")
	public String showBikeUser(Model model) {
		logger.debug("Get all bikeusers");
		model.addAttribute("bikeusers", repo.findAllByOrderByFirstName());
		return "bikeusers";
	}

	@GetMapping("/bikeusers/save")
	public String saveBikeUser( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "firstname") String firstName, //
			@RequestParam(name = "lastname") String lastName, //
			Model model) {
		BikeUser bikeuser = new BikeUser( id, firstName,lastName);
		logger.debug("Save bikeuser " + bikeuser);
		repo.save(bikeuser);

		model.addAttribute("bikeusers", repo.findAll());
		return "bikeusers";
	}

	@GetMapping("/bikeusers/delete")
	public String deleteBikeUser( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete bikeuser " + id);
		repo.deleteById(id);

		model.addAttribute("bikeusers", repo.findAll());
		return "bikeusers";
	}
}
