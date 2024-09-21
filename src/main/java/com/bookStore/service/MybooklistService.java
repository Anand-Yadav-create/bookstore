package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Mybooklist;
import com.bookStore.repository.MybookRepository;

@Service

public class MybooklistService {
	
	@Autowired
	private MybookRepository mybook;
	
	
	public void saveMyBooks(Mybooklist book) {
		
		mybook.save(book);
		
	}
	
	public List<Mybooklist> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}

}
