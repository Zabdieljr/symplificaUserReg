package com.symplifica.demouser.controller;

import com.symplifica.demouser.entity.User;
import com.symplifica.demouser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
	// add an initbinder ... to convert trim imput strings
	@InitBinder
	public void	initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
	}
	// remove leading and trailing whitespace
	// resolve issue for our validation
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
		// save the user
			userService.save(theUser);
		// use a redirect to prevent duplicate submissions
			return "redirect:/users/list";

	}

	@PostMapping ("/processForm")
			public String processForm(@Valid @ModelAttribute("user") User theUser,
									  BindingResult theBindingResult)

		{
			if (theBindingResult.hasErrors()){
				return "users/user-regform";
			}
			else {
				userService.save(theUser);
				return "users/user-confirmation";
			}
		}


}









