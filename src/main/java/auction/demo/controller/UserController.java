package auction.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auction.demo.models.User;
import auction.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/auction/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
