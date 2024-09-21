package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.Mybooklist;
import com.bookStore.service.BookService;
import com.bookStore.service.MybooklistService;

@Controller

public class BookController {
	
	@Autowired 
	private BookService service;
	
	@Autowired
	private MybooklistService myBookService;
    
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookregister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		
	List<Book> list=service.getAllbook();
//		ModelAndView m=new ModelAndView();
//	    m.setViewName("booklist");
//		m.addObject("book",list);
	
		return new ModelAndView("booklist","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		
		return "redirect:/available_books";
		
	}
	@GetMapping("/my_books")
	public String  getMybooks(Model model) {
		
		List<Mybooklist> list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		
		
		return "mybooks";
		
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMYlist(@PathVariable("id") int id) {
		
		Book b=service.getBookbyId(id);
		Mybooklist  mb=new Mybooklist(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		
		return "redirect:/my_books";
		
	}
	
	@RequestMapping("/editBook/{id}")
	
	public String editBook(@PathVariable("id") int id,Model model) {
		
		Book  b=service.getBookbyId(id);
		model.addAttribute("book",b);
		return "bookedit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	
	public String deleteBook(@PathVariable("id") int id) {
		
		service.deletebyid(id);
		return "redirect:/available_books";
	}
	
}
	
