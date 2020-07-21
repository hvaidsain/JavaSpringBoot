package com.example.datasource.datasource.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datasource.datasource.model.book.Book;
import com.example.datasource.datasource.model.mobile.Mobile;
import com.example.datasource.datasource.model.user.User;
import com.example.datasource.datasource.repository.book.BookRepository;
import com.example.datasource.datasource.repository.mobile.MobileRepository;
import com.example.datasource.datasource.repository.user.UserRepository;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MobileRepository mobileRepository;

	@PostMapping
	public void addData() {
		userRepository.save(new User(10, "John"));
		bookRepository.save(new Book(10, "Joker"));
		mobileRepository.save(new Mobile(10, "Motorola Z"));
	}

	@GetMapping("/getData/{id}")
	public Map<String, Object> getData(@PathVariable int id) {
		
		System.out.println(id);
//		List<Object> Object = userRepository.findAllActiveUsers("Harsh");
		
//		System.out.println("object"+Object);
		Optional<User> users = userRepository.findById(id);
		Optional<Book> books = bookRepository.findById(id);
		Optional<Mobile> mobiles = mobileRepository.findById(id);
		HashMap<String, Object> map = new HashMap<>();
		map.put("users", users);
		map.put("books", books);
		map.put("mobiles", mobiles);
		return map;
	}
	
//	@GetMapping("/getData/{id}")
//	public Map<String, Object> getDataById() {
//
////		List<Object> Object = userRepository.findAllActiveUsers("Harsh");
//		List<User> users = userRepository.findAll();
//		List<Book> books = bookRepository.findAll();
//		List<Mobile> mobiles = mobileRepository.findAll();
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("users", users);
//		map.put("books", books);
//		map.put("mobiles", mobiles);
//		return map;
//	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}
