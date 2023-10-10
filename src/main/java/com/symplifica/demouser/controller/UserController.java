package com.symplifica.demouser.controller;

import com.symplifica.demouser.entity.User;
import com.symplifica.demouser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
private UserService userService;
@Autowired
public UserController(UserService theUserService)
{
	userService = theUserService;
}
	@GetMapping("/showFormForReg")
	public String showFormForReg(Model theModel){
		// create model attribute to bind form data 1
		User theUser = new User();
		theModel.addAttribute("user" , theUser);
		return "users/user-regform";
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		List<User> theUsers = userService.findAll();

		// add to the spring model
		theModel.addAttribute("users", theUsers);

		return "users/list-users";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
	// create model attribute to bind form data 1
		User theUser = new User();
		theModel.addAttribute("user" , theUser);
		return "users/user-form";
	}

	@GetMapping ("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel){
	// get the user
	User theUser= userService.findById(theId);
	// set the user int the model to populate the form
	theModel.addAttribute("user", theUser);

	// send over to our form
	return "users/user-form";
	}
	@GetMapping("/delete")
	public String delete (@RequestParam("userId")int theId){
	// delete the user
		userService.deleteById(theId);
	// redirect to the user/list
		return "redirect:/users/list";

	}



@PostMapping("/save")
	public String saveUser(@ModelAttribute ("user")User theUser)
	{
		// save the employee
			userService.save(theUser);
		// use a redirect to prevent duplicate submissions
			return "redirect:/users/list";

	}

}









