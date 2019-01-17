package jo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.UserRepository;
import jo.model.entities.User;

@Controller
public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);

	@Autowired
	UserRepository repo;

	@GetMapping("/users")
	public String showUserOrderedByUserName(Model model) {
		logger.debug("Get all users");
		model.addAttribute("users", repo.findAllByOrderById());
		return orderUsers("Usr", model);
	}

	@GetMapping("/users/order")
	public String orderUsers( //
			@RequestParam String by, //
			Model model) {
		logger.debug("Order users by " + by);

		List<User> users;
		switch (by) {
		case "Rol":
			users = repo.findAllByOrderByRol();
			break;
		case "Usr":
			users = repo.findAllByOrderByUsr();
			break;
		default:
			users = repo.findAllByOrderById();
			break;
		}
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/users/save")
	public String saveUser( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "usr") String usr, //
			@RequestParam(name = "pwd") String pwd, //
			@RequestParam(name = "rol") String rol, //
			Model model) {	
		User user = new User(id, usr, pwd, rol);
		logger.debug("Save user " + user);
		repo.save(user);

		model.addAttribute("users", repo.findAll());
		return "users";
	}
	
	@GetMapping("/users/delete")
	public String deleteUser( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete user " + id);
		repo.deleteById(id);

		model.addAttribute("users", repo.findAll());
		return "users";
	}
}
