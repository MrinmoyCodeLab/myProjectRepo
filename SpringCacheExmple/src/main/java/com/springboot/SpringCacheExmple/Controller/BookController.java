package com.springboot.SpringCacheExmple.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.SpringCacheExmple.ServiceImpl.BookServiceImpl;
import com.springboot.SpringCacheExmple.Vo.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	
	@PostMapping("/book")
	public Book insertBook(@RequestBody Book book) {	
		
		return bookService.insertBook(book);
		
	}
	
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {	
		
		return bookService.updateBook(book);
		
	}
	
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {	
		
		return bookService.getBook(id);
		
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id) {	
		
		return bookService.deleteBook(id);
		
	}
	

}
