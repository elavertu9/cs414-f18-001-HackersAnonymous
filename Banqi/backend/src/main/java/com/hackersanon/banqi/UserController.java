package com.hackersanon.banqi;

import com.hackersanon.banqi.database.entity.UserEntity;
import com.hackersanon.banqi.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:8081"})
public class UserController
{
	@Autowired
	private UserServiceInterface userService;


	// /api/user/list
	@GetMapping(value = "list", produces = "application/json")
	public List listUsers(){
		return this.userService.getAllUsers();
	}

	// /api/user/add
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public UserEntity addUser(@RequestBody()UserEntity userEntity){
		this.userService.saveUser(userEntity);
		return userEntity;
	}

	@ModelAttribute("user")
	public UserEntity formBackingObject(){
		return new UserEntity();
	}

	@RequestMapping("/api/remove/{id}")
	public String removeUser(@PathVariable("id") int id){
		this.userService.removeUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/api/edit/{id}", produces = "application/json")
	public String editUser(@PathVariable("id") int id, Model model){
		model.addAttribute("user", this.userService.getUser(id));
		model.addAttribute("listUsers", this.userService.getAllUsers());
		return "user";
	}
}
