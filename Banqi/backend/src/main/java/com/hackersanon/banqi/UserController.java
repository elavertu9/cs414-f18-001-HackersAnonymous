package com.hackersanon.banqi;

import com.hackersanon.banqi.database.entity.UsersEntity;
import com.hackersanon.banqi.services.UserService;
import com.hackersanon.banqi.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController
{
	private UserService userService;
	
	@Autowired(required = true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model){
		model.addAttribute("user", new UserProfile());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
	
	public String addUser(@ModelAttribute("user") UsersEntity usersEntity){
		if(usersEntity.getId() == 0){
			this.userService.addUser(usersEntity);
		}else{
			this.userService.updateUser(usersEntity);
		}
		
		return "redirect:/users";
	}
	
	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.userService.removeUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("user", this.userService.getUser(id));
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
}
