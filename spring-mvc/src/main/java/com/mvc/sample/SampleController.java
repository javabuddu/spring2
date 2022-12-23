package com.mvc.sample;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	
	@RequestMapping("/")
	public String getSamplePage() {
		return "index";// .index.jsp
	}
	
	@RequestMapping("/test")
	public ModelAndView test() {
		ModelAndView model=new ModelAndView();
		model.addObject("name", "Buddu");
		model.setViewName("hello"); // hello.jsp + {name:"buddu"}
		return model;	}
	
	@PostMapping("/saveemp")
	public ModelAndView saveEmp(Model m, @ModelAttribute Employee emp) {
		ModelAndView model=new ModelAndView();
		if(emp!=null && (emp.getName()!=null && !emp.getName().isEmpty()) )
		{
			model.addObject("status", emp.getName());	
		}else {
			model.addObject("status", "fail");
		}
		
		model.setViewName("status");
		return model;
	}
	
	@GetMapping("/reqForm")
	public String showForm() {
		return "user-from";
	}
	
	@GetMapping("/requestParamValue")
	public String getRequestparam(Model model,@RequestParam("userName") String userName,@RequestParam("email") String userEmail) {
		model.addAttribute("userName", userName);
		model.addAttribute("email", userEmail);
		return "success";
		
	}
	
	@GetMapping("/getValidateForm")
		public String getForm(@ModelAttribute("user") User user) {
		
		return "validate-form";
		
	}
	
	@PostMapping("/validateForm")
	public String validateForm(Model model,@Valid @ModelAttribute("user") User user,BindingResult br) {
		if(br.hasErrors()) {
			return "validate-form";
		}else {
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("email", user.getUserSkill());
			
			return "success";
		}
		
	}
	

}
