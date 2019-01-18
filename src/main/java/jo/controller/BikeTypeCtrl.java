package jo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.BikeTypeRepository;

import jo.model.entities.BikeType;

@Controller
public class BikeTypeCtrl {

	private static final Logger logger = LoggerFactory.getLogger(BikeTypeCtrl.class);

	@Autowired
	BikeTypeRepository repo;

	@GetMapping("/types")
	public String showTypes(Model model) {
		logger.debug("Get all bike types");
		model.addAttribute("bikes", repo.findAllByOrderById());
		return orderTypes("Id", model);
	}

	@GetMapping("/types/order")
	public String orderTypes( //
			@RequestParam String by, //
			Model model) {
		logger.debug("Order types by " + by);

		List<BikeType> types;
		switch (by) {
		case "Id":
			types = repo.findAllByOrderById();
			break;
		case "types":
			types = repo.findAllByOrderByType();
			break;
		default:
			types = repo.findAllByOrderById();
			break;
		}
		model.addAttribute("types", types);

		return "types";
	}

	@GetMapping("/types/save")
	public String saveType( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "type") String type, //
			Model model) {
		BikeType bikeType = new BikeType(id, type);
		logger.debug("Save type " + bikeType);
		repo.save(bikeType);

		model.addAttribute("types", repo.findAll());
		return "types";
	}

	@GetMapping("/types/delete")
	public String deleteType( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete type of bike " + id);
		repo.deleteById(id);

		model.addAttribute("types", repo.findAll());
		return "types";
	}

}
