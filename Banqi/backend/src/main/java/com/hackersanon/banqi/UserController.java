package com.hackersanon.banqi;

import com.hackersanon.banqi.database.entity.UserEntity;
import com.hackersanon.banqi.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
	@Autowired
	private UserServiceInterface userService;


	@GetMapping(value = "/user/list", produces = "application/json")
	public String listUsers(Model model){
		model.addAttribute("user", new UserEntity());
		model.addAttribute("listUsers", this.userService.getAllUsers());
		return "user";
	}

	@PostMapping(value = "/user/add", produces = "application/json")
	public String addUser(@ModelAttribute("user")UserEntity userEntity){
		this.userService.saveUser(userEntity);
		return "redirect:/";
	}

	@ModelAttribute("user")
	public UserEntity formBackingObject(){
		return new UserEntity();
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id){
		this.userService.removeUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/edit/{id}", produces = "application/json")
	public String editUser(@PathVariable("id") int id, Model model){
		model.addAttribute("user", this.userService.getUser(id));
		model.addAttribute("listUsers", this.userService.getAllUsers());
		return "user";
	}
}
