package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.service.MybooklistService;

@Controller

public class Mybooklistcontroller {
	
	
	@Autowired
	
	private MybooklistService service;
	
	@RequestMapping("/deleteMylist/{id}")
	
	public String deleteMylist(@PathVariable("id") int id) {
		
		service.deleteById(id);
		
		
		return "redirect:/my_books";
	}
	
	

}
