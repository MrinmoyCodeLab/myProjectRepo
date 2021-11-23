package com.springboot.SpringCacheExmple.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.SpringCacheExmple.Dao.BookRepository;
import com.springboot.SpringCacheExmple.ServiceImpl.BookServiceImpl;
import com.springboot.SpringCacheExmple.Vo.Book;

@Service
public class BookService implements BookServiceImpl{

	
	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	@Cacheable(cacheNames="Books", key="#id")
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		Book book = new Book();
		Optional<Book> bookDetails =  bookRepository.findById(id);
		if(bookDetails.isPresent()) {
			book = bookDetails.get();
		}
		
		return book;
	}

	@Override
	public Book insertBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
		
	}

	@Override
	@CachePut(cacheNames="Books", key="#book.id")
	public Book updateBook(Book book) {
		return bookRepository.updateBookName(book.getId(), book.getName());
	}

	@Override
	@CacheEvict(cacheNames="Books", key="#id")
	public String deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);		
		return "Book Return";	
	}

}
