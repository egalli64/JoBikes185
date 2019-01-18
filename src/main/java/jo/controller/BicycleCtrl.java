package jo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.BicycleRepository;
import jo.model.entities.Bicycle;

@Controller
public class BicycleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(BicycleCtrl.class);

	@Autowired
	BicycleRepository repo;

	@GetMapping("/bicycles")
	public String showBicyclesOrderedbyId(Model model) {
		logger.debug("Get all bicycles");
		model.addAttribute("bicycles", repo.findAllByOrderById());
		return orderBicycles("Id",model);
	}
	
	@GetMapping("/bicyclesByType")
	public String showBicyclesFindByTypeId(Model model) {
		logger.debug("Get all bicycles of one kind");
		model.addAttribute("bicycles", repo.findByTypeId());
		return "bicyclesByType";
	}
	
	@GetMapping("/bicycles/order")
	public String orderBicycles( //
			@RequestParam String by, //
			Model model) {
		logger.debug("Order bicycles by " + by);

		List<Bicycle> bicycles;
		switch (by) {
		
		case "Target":
			bicycles = repo.findAllByOrderByTarget();
			break;
		case "TypeId":
			bicycles = repo.findAllByOrderByTypeId();
			break;
		case "Price":
			bicycles = repo.findAllByOrderByPrice();
			break;
		case "Brand":
			bicycles = repo.findAllByOrderByBrand();
			break;
		default:
			bicycles = repo.findAllByOrderById();
			break;
		}
		model.addAttribute("bicycles", bicycles);
		model.addAttribute("by", by);
		return "bicycles";
	}

	@GetMapping("/bicycles/save")
	public String saveBicycles( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "target") String tar, //
			@RequestParam(name = "typeId") Integer tId, //
			@RequestParam(name = "brand") String bra, //
			@RequestParam(name = "model") String mod, //
			@RequestParam(name = "price") Double pri, //
			@RequestParam(name = "stock") Integer sto, //
			Model model) {
		Bicycle bicycle = new Bicycle( id, tar, tId, bra, mod, pri, sto);
		logger.debug("Save bicycle " + bicycle);
		repo.save(bicycle);

		model.addAttribute("bicycles", repo.findAll());
		return "bicycles";
	}

	@GetMapping("/bicycles/delete")
	public String deleteBicycles( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete bicycle " + id);
		repo.deleteById(id);

		model.addAttribute("bicycles", repo.findAll());
		return "bicycles";
	}
}